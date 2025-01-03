package andrehsvictor.anibaze.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonInclude;

import andrehsvictor.anibaze.dto.error.FieldErrorDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payload<T, E> {
    private T data;
    private Long totalElements;
    private Integer totalPages;
    private Integer pageNumber;
    private Integer pageSize;
    private Boolean hasNext;
    private Boolean hasPrevious;
    private String sort;
    private List<E> errors = new ArrayList<>();

    public static Payload<?, String> error(String message) {
        Payload<?, String> payload = new Payload<>();
        payload.getErrors().add(message);
        return payload;
    }

    public static <T> Payload<?, FieldErrorDto> error(FieldErrorDto fieldError) {
        Payload<?, FieldErrorDto> payload = new Payload<>();
        payload.getErrors().add(fieldError);
        return payload;
    }

    public static <T> Payload<T, ?> success(T data) {
        Payload<T, ?> payload = new Payload<>();
        payload.setData(data);
        return payload;
    }

    public static <T> Payload<Page<T>, ?> success(Page<T> page) {
        Payload<Page<T>, ?> payload = new Payload<>();
        payload.setData(page);
        payload.setTotalElements(page.getTotalElements());
        payload.setTotalPages(page.getTotalPages());
        payload.setPageNumber(page.getNumber());
        payload.setPageSize(page.getSize());
        payload.setHasNext(page.hasNext());
        payload.setHasPrevious(page.hasPrevious());
        payload.setSort(page.getSort().toString());
        return payload;
    }
}

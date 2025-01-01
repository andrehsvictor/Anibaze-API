package andrehsvictor.anibaze.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserDto {
    private String id;
    private String name;
    private String username;
    private String bio;
    private String imageUrl;
    private String createdAt;
    private String updatedAt;
}

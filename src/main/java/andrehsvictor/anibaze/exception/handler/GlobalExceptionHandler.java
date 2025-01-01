package andrehsvictor.anibaze.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import andrehsvictor.anibaze.dto.Payload;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Payload<?, String>> handleAllExceptions(Exception ex) {
        log.error("An internal error occurred: ", ex);
        String message = "An internal error occurred. Please try again later.";
        return ResponseEntity.internalServerError()
                .body(Payload.error(message));
    }

    @ExceptionHandler(AuthenticationException.class)
    public final ResponseEntity<Payload<?, String>> handleAuthenticationException(AuthenticationException ex) {
        return ResponseEntity.status(401)
                .body(Payload.error(ex.getMessage()));
    }
}

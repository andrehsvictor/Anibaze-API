package andrehsvictor.anibaze.dto.token;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "password")
public class CredentialsDto {
    private String username;
    private String password;
}

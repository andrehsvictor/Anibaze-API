package andrehsvictor.anibaze.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUserDto {
    private String name;
    private String username;
    private String email;
    private String password;
    private String bio;
    private String imageUrl;
}

package andrehsvictor.anibaze.user;

import org.mapstruct.Mapper;

import andrehsvictor.anibaze.dto.user.GetUserDto;
import andrehsvictor.anibaze.dto.user.PostUserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    GetUserDto userToGetUserDto(User user);

    User postUserDtoToUser(PostUserDto postUserDto);

}

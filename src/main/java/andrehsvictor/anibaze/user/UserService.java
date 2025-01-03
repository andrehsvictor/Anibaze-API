package andrehsvictor.anibaze.user;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import andrehsvictor.anibaze.dto.user.GetUserDto;
import andrehsvictor.anibaze.dto.user.PostUserDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public GetUserDto toGetUserDto(User user) {
        return userMapper.userToGetUserDto(user);
    }

    public Page<GetUserDto> toGetUserDtoPage(Page<User> users) {
        return users.map(this::toGetUserDto);
    }

    public User create(PostUserDto postUserDto) {
        User user = userMapper.postUserDtoToUser(postUserDto);
        hashPassword(postUserDto, user);
        return userRepository.save(user);
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    private void hashPassword(PostUserDto postUserDto, User user) {
        user.setPassword(passwordEncoder.encode(postUserDto.getPassword()));
    }
}

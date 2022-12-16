package pl.kielce.tu.isi.userapp.model.components;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kielce.tu.isi.userapp.model.dao.ProducerRepository;
import pl.kielce.tu.isi.userapp.model.dao.UserRepository;
import pl.kielce.tu.isi.userapp.model.dto.ProducerDto;
import pl.kielce.tu.isi.userapp.model.dto.UserDto;
import pl.kielce.tu.isi.userapp.model.entities.Producer;
import pl.kielce.tu.isi.userapp.model.entities.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserRepositoryComponent {

    private final UserRepository userRepository;

    public UserDto saveUser(UserDto userDto) {
        User user = userRepository.save(userDto.createEntity());
        return new UserDto(user);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }


}

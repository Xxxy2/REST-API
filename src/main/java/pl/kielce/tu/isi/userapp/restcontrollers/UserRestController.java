package pl.kielce.tu.isi.userapp.restcontrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.isi.userapp.model.components.UserRepositoryComponent;
import pl.kielce.tu.isi.userapp.model.dto.UserDto;
import pl.kielce.tu.isi.userapp.model.entities.User;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserRepositoryComponent userRepositoryComponent;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userRepositoryComponent.saveUser(userDto);
    }

    @GetMapping(value = "all", produces = "application/json")
    public List<UserDto> findAll() {
        return userRepositoryComponent.findAll();
    }


    @GetMapping(value = "/{userLogin}", produces = "application/json")
    public User findByUserLogin(@PathVariable("userLogin") String userLogin) {
        return userRepositoryComponent.findByLogin(userLogin);
    }
}
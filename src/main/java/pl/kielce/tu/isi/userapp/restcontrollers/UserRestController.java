package pl.kielce.tu.isi.userapp.restcontrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.isi.userapp.model.components.ProducerRepositoryComponent;
import pl.kielce.tu.isi.userapp.model.components.UserRepositoryComponent;
import pl.kielce.tu.isi.userapp.model.dto.ProducerDto;
import pl.kielce.tu.isi.userapp.model.dto.UserDto;

import java.util.List;

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

}

package pl.kielce.tu.isi.userapp.restcontrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.isi.userapp.model.components.ProducerRepositoryComponent;
import pl.kielce.tu.isi.userapp.model.dto.ProducerDto;

import java.util.List;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class LoginRestController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

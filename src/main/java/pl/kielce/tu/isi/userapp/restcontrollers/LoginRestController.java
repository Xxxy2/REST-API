package pl.kielce.tu.isi.userapp.restcontrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class LoginRestController {

    @GetMapping("/all")
    public String hello() {
        return "hello all";
    }
    @GetMapping("/user")
    public String helloUser() {
        return "hello user";
    }
    @GetMapping("/admin")
    public String helloadmin() {
        return "hello admin";
    }
}

package pl.kielce.tu.isi.userapp.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kielce.tu.isi.userapp.model.entities.Producer;
import pl.kielce.tu.isi.userapp.model.entities.Product;
import pl.kielce.tu.isi.userapp.model.entities.User;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;


    private String login;

    private String password;


    private Date lastLogin;


    public User createEntity() {
        User user = new User();
        user.setLogin(this.login);
        user.setLastLogin(this.lastLogin);
        user.setPassword(this.password);
        return user;
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.lastLogin = user.getLastLogin();
        this.password = user.getPassword();
        }

}

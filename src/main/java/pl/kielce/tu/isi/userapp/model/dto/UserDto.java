package pl.kielce.tu.isi.userapp.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    private String userRole;

    private  String userStatus;

    public User createEntity() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(this.password);
        User user = new User();
        user.setLogin(this.login);
        user.setLastLogin(this.lastLogin);
        user.setPassword(encodedPassword);
        //user.setPassword(this.password);
        user.setUserRole("user");
        return user;
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.lastLogin = user.getLastLogin();
        this.password = user.getPassword();
       this.userRole = user.getUserRole();
       this.userStatus=user.getUserstatus();
        }


    public User updateEntity(UserDto userDto, Long userId) {
        User user = new User();
        user.setId(userId);
        user.setLogin(userDto.getLogin());
        user.setLastLogin(userDto.getLastLogin());
        user.setPassword(userDto.getPassword());
        user.setUserRole(userDto.getUserRole());
        user.setUserstatus(userDto.getUserStatus());
        return user;
    }

}

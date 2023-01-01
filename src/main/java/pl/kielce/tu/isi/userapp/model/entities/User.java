package pl.kielce.tu.isi.userapp.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_login", nullable = false, unique = true)
    private String login;
    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_last_login", nullable = false)
    private Date lastLogin;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "user_status")
    private String userstatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpatient", referencedColumnName = "id")
    Patient patient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iddoctor", referencedColumnName = "id")
    Doctor doctor;

}

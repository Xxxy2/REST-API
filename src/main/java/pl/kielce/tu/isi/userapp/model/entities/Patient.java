package pl.kielce.tu.isi.userapp.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient")
@Data

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patientname", nullable = false)
    private String name;

    @Column(name = "patientlastname", nullable = false)
    private String lastName;

    @Column(name = "patientpesel", nullable = false, unique = true)
    private String patientPesel;

    @OneToMany(mappedBy = "patient")
    private List<Visit> visitsList;

    @OneToOne(mappedBy = "patient")
    @JoinColumn(name = "iduser", nullable = false)
    private User user;

}

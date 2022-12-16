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

    @Column(name = "patientname", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "patient")
    private List<Visit> visitsList;

}

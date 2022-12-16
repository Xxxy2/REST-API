package pl.kielce.tu.isi.userapp.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "visit")
@Data
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patientId", nullable = false)
    private Long patientId;

    @Column(name = "doctorId", nullable = false)
    private String doctorId;

    @Column(name = "visitStatus", nullable = false)
    private String visitStatus;


    @ManyToOne
    @JoinColumn(name = "idPatient", nullable = false)
    private Patient patient;

}

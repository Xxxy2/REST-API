package pl.kielce.tu.isi.userapp.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "visit")
@Data
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visit_status", nullable = false)
    private String visitStatus;

    @Column(name = "visit_note")
    private String visitNote;

    @Column(name = "visit_date", nullable = false)
    private Date visitDate;


    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    private Doctor doctor;
    @OneToMany(mappedBy = "visit")
    private List<Medicine> medicineList;


}

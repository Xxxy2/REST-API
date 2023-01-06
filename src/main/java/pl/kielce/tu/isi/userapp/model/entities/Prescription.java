package pl.kielce.tu.isi.userapp.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "prescription")
@Data
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prescription_note")
    private String prescriptionNote;

    @ManyToOne
    @JoinColumn(name = "id_medicine")
    private Medicine medicine;

    @ManyToOne
    @JoinColumn(name = "id_visit")
    private Visit visit;

}

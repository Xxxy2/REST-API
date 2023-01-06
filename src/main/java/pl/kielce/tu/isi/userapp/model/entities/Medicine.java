package pl.kielce.tu.isi.userapp.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medicine")

@Data
public class Medicine {
// id =1 name=paracetamol amount =3 price 3 status ...
// id =2 name=paracetamol amount =1 price 1 status ...
// id =3 name=paracetamol amount =12 price 12 status ...
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "amount", nullable = false)
    private Long amount = 10L;
    @Column(name = "price", nullable = false)
    private Float price;
    @Column(name = "status", nullable = false)
    private String medicineStatus;



    @OneToMany(mappedBy = "medicine")
    private List<Prescription> prescriptionList;


}

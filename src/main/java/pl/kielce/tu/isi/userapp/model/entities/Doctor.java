package pl.kielce.tu.isi.userapp.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
@Data


public class Doctor {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "doctorname", nullable = false)
        private String doctorName;

        @Column(name = "doctorlastname", nullable = false)
        private String doctorLastName;

        @Column(name = "doctorpesel", nullable = false, unique = true)
        private String doctorPesel;

        @Column(name = "doctorspecialization", nullable = false)
        private String doctorSpecialization;

        @Column(name = "doctorstatus", nullable = false)
        private String doctorStatus;

        @OneToMany(mappedBy = "doctor")
        private List<Visit> visitsList;

        @OneToOne(mappedBy = "doctor")
        @JoinColumn(name = "iduser", nullable = false)
        private User user;

    }






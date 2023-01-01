package pl.kielce.tu.isi.userapp.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kielce.tu.isi.userapp.model.entities.*;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class VisitDto {

    private Long id;



    private String visitStatus;
    private Long idPatient;
    private Long idDoctor;


    public Visit createEntity() {
        Patient patient = new Patient();
        patient.setId(this.idPatient);
        Doctor doctor = new Doctor();
        doctor.setId(this.idDoctor);
        Visit visit = new Visit();
        visit.setVisitStatus(this.visitStatus);
        visit.setPatient(patient);
        return visit;
    }

    public VisitDto(Visit visit) {
        this.id = visit.getId();
        this.idDoctor = visit.getDoctor().getId();
        this.visitStatus = visit.getVisitStatus();
        this.idPatient = visit.getPatient().getId();
    }


    public Visit updateEntity(VisitDto visitDto, long newId) {

//        Producer producer = new Producer();
//        producer.setId(this.idProducer);

        Visit visit = new Visit();
        visit.setId(newId);
//        product.setName(productDto.getName());
//        product.setAmount(productDto.getAmount());
//        product.setPrice(productDto.getPrice());
//
//        product.setProducer(producer);

        return visit;
    }
}
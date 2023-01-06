package pl.kielce.tu.isi.userapp.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kielce.tu.isi.userapp.model.entities.*;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class VisitDto {

    private Long id;

    private Date visitDate;

    private String visitStatus;

    private String visitNote;
    private Long idPatient;
    private Long idDoctor;

    private List<Long> prescriptionList;


    public Visit createEntity() {
        Patient patient = new Patient();
        patient.setId(this.idPatient);
        Doctor doctor = new Doctor();
        doctor.setId(this.idDoctor);
        Visit visit = new Visit();
        visit.setVisitNote(this.visitNote);
        visit.setVisitDate(this.visitDate);
        visit.setVisitStatus(this.visitStatus);
        visit.setPatient(patient);
        visit.setDoctor(doctor);
        visit.setPrescriptionList(new ArrayList<>());
        return visit;
    }

    public VisitDto(Visit visit) {
        this.id = visit.getId();
        this.idDoctor = visit.getDoctor().getId();
        this.visitDate=visit.getVisitDate();
        this.visitStatus = visit.getVisitStatus();
        this.visitNote = visit.getVisitNote();
        this.idPatient = visit.getPatient().getId();
       // this.idPrescription=visit.getPrescription().getId();
        this.prescriptionList = visit.getPrescriptionList().stream().map(Prescription::getId).collect(Collectors.toList());
        //this.medicineList = visit.getMedicineList().stream().map(Medicine::getId).collect(Collectors.toList());
    }


    public Visit updateEntity(VisitDto visitDto, long visitId) {


        Visit visit = new Visit();
        visit.setId(visitId);
        visit.setVisitStatus(visitDto.getVisitStatus());
        visit.setVisitNote(visitDto.getVisitNote());

        return visit;
    }
}
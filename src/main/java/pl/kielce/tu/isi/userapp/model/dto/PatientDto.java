package pl.kielce.tu.isi.userapp.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kielce.tu.isi.userapp.model.entities.Doctor;
import pl.kielce.tu.isi.userapp.model.entities.Patient;
import pl.kielce.tu.isi.userapp.model.entities.User;


@Data
@NoArgsConstructor

public class PatientDto {

    private Long id;
    private String Name;
    private String LastName;
    private String patientPesel;
    private String patientStatus;
    private  Long idUser;


    public Patient createEntity() {
        User user = new User();
        user.setId(this.idUser);

        Patient patient = new Patient();
        patient.setName(this.Name);
        patient.setPatientPesel(this.patientPesel);
        patient.setPatientStatus(this.patientStatus);
        patient.setLastName(this.LastName);
        patient.setUser(user);
        return patient;
    }


    public PatientDto(Patient patient){
        this.id=patient.getId();
        this.Name=patient.getName();
        this.LastName=patient.getLastName();
        this.patientPesel=patient.getPatientPesel();
        this.patientStatus=patient.getPatientStatus();
        this.idUser=patient.getUser().getId();
    }


    public Patient updateEntity(PatientDto patientDto, long patientId) {
        User user = new User();
        user.setId(this.idUser);
        Patient patient = new Patient();
        patient.setId(patientId);
        patient.setLastName(patientDto.getLastName());
        patient.setPatientPesel(patientDto.getPatientPesel());
        patient.setPatientStatus(patientDto.getPatientStatus());
        patient.setName(patientDto.getName());
        patient.setUser(user);
        return patient;
    }
    public Patient updateEntity(PatientDto patientDto, long patientId, long userId) {
        User user = new User();
        user.setId(userId);
        Patient patient = new Patient();
        patient.setId(patientId);
        patient.setLastName(patientDto.getLastName());
        patient.setPatientPesel(patientDto.getPatientPesel());
        patient.setPatientStatus(patientDto.getPatientStatus());
        patient.setName(patientDto.getName());
        patient.setUser(user);
        return patient;
    }


}



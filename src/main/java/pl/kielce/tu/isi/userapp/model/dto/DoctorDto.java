package pl.kielce.tu.isi.userapp.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kielce.tu.isi.userapp.model.entities.*;


@Data
@NoArgsConstructor

public class DoctorDto {

    private Long id;
    private String doctorName;
    private String doctorLastName;
    private String doctorPesel;
    private String doctorSpecialization;
    private String doctorStatus;
    private  Long idUser;


    public Doctor createEntity() {
        User user = new User();
        user.setId(this.idUser);

        Doctor doctor = new Doctor();
        doctor.setDoctorName(this.doctorName);
        doctor.setDoctorPesel(this.doctorPesel);
        doctor.setDoctorStatus(this.doctorStatus);
        doctor.setDoctorSpecialization(this.doctorSpecialization);
        doctor.setDoctorLastName(this.doctorLastName);
        doctor.setUser(user);
        return doctor;
    }


    public DoctorDto( Doctor doctor){
        this.id=doctor.getId();
        this.doctorLastName=doctor.getDoctorLastName();
        this.doctorName=doctor.getDoctorName();
        this.doctorPesel=doctor.getDoctorPesel();
        this.doctorSpecialization=doctor.getDoctorSpecialization();
        this.doctorStatus=doctor.getDoctorStatus();
        this.idUser=doctor.getUser().getId();
    }


    public Doctor updateEntity(DoctorDto doctorDto, long doctorId) {
        User user = new User();
        user.setId(this.idUser);
        Doctor doctor = new Doctor();
        doctor.setId(doctorId);
        doctor.setDoctorPesel(doctorDto.getDoctorPesel());
        doctor.setDoctorName(doctorDto.getDoctorName());
        doctor.setDoctorSpecialization(doctorDto.getDoctorSpecialization());
        doctor.setDoctorStatus(doctorDto.getDoctorStatus());
        doctor.setUser(user);
        doctor.setDoctorLastName(doctorDto.getDoctorLastName());

        return doctor;
    }

    public Doctor updateEntity(DoctorDto doctorDto, long doctorId, long userId) {
        User user = new User();
        user.setId(userId);
        Doctor doctor = new Doctor();
        doctor.setId(doctorId);
        doctor.setDoctorPesel(doctorDto.getDoctorPesel());
        doctor.setDoctorName(doctorDto.getDoctorName());
        doctor.setDoctorSpecialization(doctorDto.getDoctorSpecialization());
        doctor.setDoctorStatus(doctorDto.getDoctorStatus());
        doctor.setUser(user);
        doctor.setDoctorLastName(doctorDto.getDoctorLastName());

        return doctor;
    }

}

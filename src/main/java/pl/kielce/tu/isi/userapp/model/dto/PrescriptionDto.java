package pl.kielce.tu.isi.userapp.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kielce.tu.isi.userapp.model.entities.*;


@Data
@NoArgsConstructor

public class PrescriptionDto {

        private Long id;
        private String prescriptionNote;
        private Long medicine;
        private Long visit;

        public Prescription createEntity() {

            Medicine medicine = new Medicine();
            medicine.setId(this.medicine);
            Visit visit =  new Visit();
            visit.setId(this.visit);

            Prescription prescription = new Prescription();
            prescription.setPrescriptionNote(this.prescriptionNote);
            prescription.setVisit(visit);
            prescription.setMedicine(medicine);
            return prescription;
        }

        public PrescriptionDto(Prescription prescription) {
            this.id=prescription.getId();
            this.prescriptionNote=prescription.getPrescriptionNote();
            this.medicine=prescription.getMedicine().getId();
            this.visit=prescription.getVisit().getId();
           }

        public Prescription updateEntity(PrescriptionDto prescriptionDto, long prescriptionId) {

            Prescription prescription = new Prescription();
            prescription.setId(prescriptionId);
            prescription.setPrescriptionNote(prescriptionDto.prescriptionNote);

            return prescription;
        }
    }

package pl.kielce.tu.isi.userapp.model.components;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kielce.tu.isi.userapp.model.dao.PrescriptionRepository;
import pl.kielce.tu.isi.userapp.model.dao.VisitRepository;
import pl.kielce.tu.isi.userapp.model.dto.PrescriptionDto;
import pl.kielce.tu.isi.userapp.model.dto.VisitDto;
import pl.kielce.tu.isi.userapp.model.entities.Prescription;
import pl.kielce.tu.isi.userapp.model.entities.Visit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class PrescriptionRepositoryComponent {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionDto savePrescription(PrescriptionDto prescriptionDto) {
        Prescription prescription = prescriptionRepository.save(prescriptionDto.createEntity());
        return new PrescriptionDto(prescription);
    }

    public List<PrescriptionDto> findAll() {
        return prescriptionRepository.findAll().stream()
                .map(prescription -> new PrescriptionDto(prescription))
                .collect(Collectors.toList());
    }

//    public List<ProductDto> findAll(Integer pageNumber, Integer pageSize) {
//        return productRepository.findAll(PageRequest.of(pageNumber, pageSize)).stream()
//                .map(product -> new ProductDto(product))
//                .collect(Collectors.toList());
//    }

//    public List<ProductDto> findAllByPriceBetween(Long minPrice, Long maxPrice) {
//        return productRepository.findByPriceBetween(minPrice.floatValue(), maxPrice.floatValue()).stream()
//                .map(product -> new ProductDto(product))
//                .collect(Collectors.toList());
//    }

//    public List<ProductDto> findByProducerNipLike(String nipLike) {
//        return productRepository.findByProducerNipLike(String.format("%%%s%%", nipLike)).stream().map(ProductDto::new).collect(Collectors.toList());
//    }

    public Stream<PrescriptionDto> findById(long prescriptionId) {

        return prescriptionRepository.findById(prescriptionId).stream().map(PrescriptionDto::new);
    }
//    public List<VisitDto> findVisitsByDoctor_IdAndVisitStatus(Long doctorId,String visitStatus){
//
//        return visitRepository.findVisitsByDoctor_IdAndVisitStatus(doctorId,visitStatus).stream().map(visit -> new VisitDto(visit))
//                .collect(Collectors.toList());
//    }
//
//    public Long countVisitsByDoctor_IdAndVisitStatus(Long doctorId,String visitStatus){
//
//        return visitRepository.countVisitsByDoctor_IdAndVisitStatus(doctorId,visitStatus);
//    }

//    public Stream<ProductDto> findByName(String prodName) {
//
//        return visitRepository.findByName(prodName).stream().map(ProductDto::new);
//    }

    public PrescriptionDto updatePrescription(PrescriptionDto prescriptionDto, long id) {
        Prescription prescription = prescriptionRepository.save(prescriptionDto.updateEntity(prescriptionDto,id));
         return  new PrescriptionDto(prescription);
    }

}

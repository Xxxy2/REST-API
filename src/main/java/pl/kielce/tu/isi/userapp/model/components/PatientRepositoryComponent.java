package pl.kielce.tu.isi.userapp.model.components;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kielce.tu.isi.userapp.model.dao.PatientRepository;
import pl.kielce.tu.isi.userapp.model.dao.VisitRepository;
import pl.kielce.tu.isi.userapp.model.dto.PatientDto;
import pl.kielce.tu.isi.userapp.model.dto.VisitDto;
import pl.kielce.tu.isi.userapp.model.entities.Patient;
import pl.kielce.tu.isi.userapp.model.entities.Visit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class PatientRepositoryComponent {

    private final PatientRepository patientRepository;

    public PatientDto savePatient(PatientDto patientDto) {

        Patient patient = patientRepository.save(patientDto.createEntity());
        return new PatientDto(patient);
    }

    public List<PatientDto> findAll() {
        return patientRepository.findAll().stream()
                .map(patient -> new PatientDto(patient))
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

    public Stream<PatientDto> findById(long patientId) {

        return patientRepository.findById(patientId).stream().map(PatientDto::new);
    }
    public List<VisitDto> findVisitsByDoctor_IdAndVisitStatus(Long doctorId,String visitStatus){

        return patientRepository.findVisitsByDoctor_IdAndVisitStatus(doctorId,visitStatus).stream().map(visit -> new VisitDto(visit))
                .collect(Collectors.toList());
    }

    public Long countVisitsByDoctor_IdAndVisitStatus(Long doctorId,String visitStatus){

        return patientRepository.countVisitsByDoctor_IdAndVisitStatus(doctorId,visitStatus);
    }



    public PatientDto updatePatient(PatientDto patientDto, long id) {
        Patient patient = patientRepository.save(patientDto.updateEntity(patientDto,id));
        return new PatientDto(patient);
    }

}

package pl.kielce.tu.isi.userapp.model.components;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kielce.tu.isi.userapp.model.dao.DoctorRepository;
import pl.kielce.tu.isi.userapp.model.dto.DoctorDto;
import pl.kielce.tu.isi.userapp.model.dto.VisitDto;
import pl.kielce.tu.isi.userapp.model.entities.Doctor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class DoctorRepositoryComponent {

    private final DoctorRepository doctorRepository;

    public DoctorDto saveDoctor(DoctorDto doctorDto) {

        Doctor doctor = doctorRepository.save(doctorDto.createEntity());
        return new DoctorDto(doctor);
    }

    public List<DoctorDto> findAll() {
        return doctorRepository.findAll().stream()
                .map(doctor -> new DoctorDto(doctor))
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

    public Stream<DoctorDto> findById(long doctorId) {

        return doctorRepository.findById(doctorId).stream().map(DoctorDto::new);
    }
    public List<VisitDto> findVisitsByDoctor_IdAndVisitStatus(Long doctorId,String visitStatus){

        return doctorRepository.findVisitsByDoctor_IdAndVisitStatus(doctorId,visitStatus).stream().map(visit -> new VisitDto(visit))
                .collect(Collectors.toList());
    }

    public Long countVisitsByDoctor_IdAndVisitStatus(Long doctorId,String visitStatus){

        return doctorRepository.countVisitsByDoctor_IdAndVisitStatus(doctorId,visitStatus);
    }



    public DoctorDto updateDoctor(DoctorDto doctorDto, long id) {
        Doctor doctor = doctorRepository.save(doctorDto.updateEntity(doctorDto,id));
        return new DoctorDto(doctor);
    }

}

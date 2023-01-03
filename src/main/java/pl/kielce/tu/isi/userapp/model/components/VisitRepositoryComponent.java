package pl.kielce.tu.isi.userapp.model.components;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kielce.tu.isi.userapp.model.dao.ProductRepository;
import pl.kielce.tu.isi.userapp.model.dao.VisitRepository;
import pl.kielce.tu.isi.userapp.model.dto.ProductDto;
import pl.kielce.tu.isi.userapp.model.dto.VisitDto;
import pl.kielce.tu.isi.userapp.model.entities.Product;
import pl.kielce.tu.isi.userapp.model.entities.Visit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class VisitRepositoryComponent {

    private final VisitRepository visitRepository;

    public VisitDto saveVisit(VisitDto visitDto) {
        Visit visit = visitRepository.save(visitDto.createEntity());
        return new VisitDto(visit);
    }

    public List<VisitDto> findAll() {
        return visitRepository.findAll().stream()
                .map(visit -> new VisitDto(visit))
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

    public Stream<VisitDto> findById(long visitId) {

        return visitRepository.findById(visitId).stream().map(VisitDto::new);
    }
    public List<VisitDto> findVisitsByDoctor_IdAndVisitStatus(Long doctorId,String visitStatus){

        return visitRepository.findVisitsByDoctor_IdAndVisitStatus(doctorId,visitStatus).stream().map(visit -> new VisitDto(visit))
                .collect(Collectors.toList());
    }

    public Long countVisitsByDoctor_IdAndVisitStatus(Long doctorId,String visitStatus){

        return visitRepository.countVisitsByDoctor_IdAndVisitStatus(doctorId,visitStatus);
    }

//    public Stream<ProductDto> findByName(String prodName) {
//
//        return visitRepository.findByName(prodName).stream().map(ProductDto::new);
//    }

    public VisitDto updateVisit(VisitDto visitDto, long id) {
        Visit visit = visitRepository.save(visitDto.updateEntity(visitDto,id));
        return new VisitDto(visit);
    }

}

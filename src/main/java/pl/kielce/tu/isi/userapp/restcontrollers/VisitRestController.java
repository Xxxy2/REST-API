package pl.kielce.tu.isi.userapp.restcontrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.isi.userapp.model.components.ProductRepositoryComponent;
import pl.kielce.tu.isi.userapp.model.components.VisitRepositoryComponent;
import pl.kielce.tu.isi.userapp.model.dto.ProductDto;
import pl.kielce.tu.isi.userapp.model.dto.VisitDto;
import pl.kielce.tu.isi.userapp.model.entities.Visit;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/visits")
@RequiredArgsConstructor
public class VisitRestController {

    private final VisitRepositoryComponent visitRepositoryComponent;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public VisitDto saveVisit(@RequestBody VisitDto visitDto) {
        return visitRepositoryComponent.saveVisit(visitDto);
    }

    @GetMapping(value = "all", produces = "application/json")
    public List<VisitDto> findAllVisits() {
        return visitRepositoryComponent.findAll();
    }

//    @GetMapping(produces = "application/json")
//    public List<ProductDto> findAllProductsWithPagination(@PathParam("page") Integer pageNumber, @PathParam("size") Integer pageSize) {
//        return productRepositoryComponent.findAll(pageNumber, pageSize);
//    }

//    @GetMapping(value = "/by-price/{minPrice}/{maxPrice}", produces = "application/json")
//    public List<ProductDto> findProductsByPriceBetween(@PathVariable("minPrice") Long minPrice, @PathVariable("maxPrice") Long maxPrice) {
//        return productRepositoryComponent.findAllByPriceBetween(minPrice, maxPrice);
//    }
//
//    @GetMapping(value = "/producer-nip/{nipLike}", produces = "application/json")
//    public List<ProductDto> findByProducerNipLike(@PathVariable("nipLike") String nipLike) {
//        return productRepositoryComponent.findByProducerNipLike(nipLike);
//    }

    @GetMapping(value = "/{visitId}", produces = "application/json")
    public Stream<VisitDto> findById(@PathVariable("visitId") long visitId) {
        return visitRepositoryComponent.findById(visitId);
    }

//    @GetMapping(value = "")
//    public Stream<VisitDto> findById(@RequestParam long visitId) {
//        return visitRepositoryComponent.findById(visitId);
//    }


//    @GetMapping(value = "/s/{prodName}", produces = "application/json")
//    public Stream<ProductDto> findByName(@PathVariable("prodName") String prodName) {
//        return productRepositoryComponent.findByName(prodName);
//    }

    @GetMapping(value = "/", produces = "application/json")
    public List<VisitDto> findVisitsByDoctor_IdAndVisitStatus(@RequestParam long doctorId, @RequestParam String visitStatus) {
        return visitRepositoryComponent.findVisitsByDoctor_IdAndVisitStatus(doctorId,visitStatus);
    }

//    @GetMapping(value = "/d/{doctorId}/{visitStatus}", produces = "application/json")
//    public List<VisitDto> findVisitsByDoctor_IdAndVisitStatus(@PathVariable("doctorId") long doctorId, @PathVariable("visitStatus") String visitStatus) {
//        return visitRepositoryComponent.findVisitsByDoctor_IdAndVisitStatus(doctorId,visitStatus);
//    }

    @GetMapping(value = "/count/{doctorId}/{visitStatus}", produces = "application/json")
    public Long countVisitsByDoctor_IdAndVisitStatus(@PathVariable("doctorId") long doctorId, @PathVariable("visitStatus") String visitStatus) {
        return visitRepositoryComponent.countVisitsByDoctor_IdAndVisitStatus(doctorId,visitStatus);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable( "id" ) Long id, @RequestBody VisitDto visitDto) {
        visitRepositoryComponent.updateVisit(visitDto,id);
    }
}

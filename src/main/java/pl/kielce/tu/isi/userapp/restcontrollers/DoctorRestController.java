package pl.kielce.tu.isi.userapp.restcontrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.isi.userapp.model.components.DoctorRepositoryComponent;
import pl.kielce.tu.isi.userapp.model.components.PatientRepositoryComponent;
import pl.kielce.tu.isi.userapp.model.dto.DoctorDto;
import pl.kielce.tu.isi.userapp.model.dto.PatientDto;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorRestController {

    private final DoctorRepositoryComponent doctorRepositoryComponent;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public DoctorDto saveDoctor(@RequestBody DoctorDto doctorDto) {
        return doctorRepositoryComponent.saveDoctor(doctorDto);
    }

    @GetMapping(value = "all", produces = "application/json")
    public List<DoctorDto> findAllDoctors() {
        return doctorRepositoryComponent.findAll();
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

    @GetMapping(value = "/{prescriptionId}", produces = "application/json")
    public Stream<DoctorDto> findById(@PathVariable("doctorId") long doctorId) {
        return doctorRepositoryComponent.findById(doctorId);
    }

//    @GetMapping(value = "")
//    public Stream<VisitDto> findById(@RequestParam long visitId) {
//        return visitRepositoryComponent.findById(visitId);
//    }


//    @GetMapping(value = "/s/{prodName}", produces = "application/json")
//    public Stream<ProductDto> findByName(@PathVariable("prodName") String prodName) {
//        return productRepositoryComponent.findByName(prodName);
//    }

//    @GetMapping(value = "/", produces = "application/json")
//    public List<PrescriptionDto> findVisitsByDoctor_IdAndVisitStatus(@RequestParam long doctorId, @RequestParam String visitStatus) {
//        return visitRepositoryComponent.findVisitsByDoctor_IdAndVisitStatus(doctorId,visitStatus);
//    }
//
////    @GetMapping(value = "/d/{doctorId}/{visitStatus}", produces = "application/json")
////    public List<VisitDto> findVisitsByDoctor_IdAndVisitStatus(@PathVariable("doctorId") long doctorId, @PathVariable("visitStatus") String visitStatus) {
////        return visitRepositoryComponent.findVisitsByDoctor_IdAndVisitStatus(doctorId,visitStatus);
////    }
//
//    @GetMapping(value = "/count/{doctorId}/{visitStatus}", produces = "application/json")
//    public Long countVisitsByDoctor_IdAndVisitStatus(@PathVariable("doctorId") long doctorId, @PathVariable("visitStatus") String visitStatus) {
//        return visitRepositoryComponent.countVisitsByDoctor_IdAndVisitStatus(doctorId,visitStatus);
//    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable( "id" ) Long id, @RequestBody DoctorDto doctorDto) {
        doctorRepositoryComponent.updateDoctor(doctorDto,id);
    }
}

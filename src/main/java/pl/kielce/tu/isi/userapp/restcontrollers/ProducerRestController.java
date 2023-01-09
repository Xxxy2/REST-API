package pl.kielce.tu.isi.userapp.restcontrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kielce.tu.isi.userapp.model.components.ProducerRepositoryComponent;
import pl.kielce.tu.isi.userapp.model.dto.ProducerDto;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/producers")
@RequiredArgsConstructor
public class ProducerRestController {

    private final ProducerRepositoryComponent producerRepositoryComponent;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ProducerDto saveProducer(@RequestBody ProducerDto producerDto) {
        return producerRepositoryComponent.saveProducer(producerDto);
    }

    @GetMapping(value = "all", produces = "application/json")
    public List<ProducerDto> findAllProducers() {
        return producerRepositoryComponent.findAll();
    }

//    @GetMapping(produces = "application/json")
//    public List<ProducerDto> findAllProducersWithPagination(@PathParam("page") Integer pageNumber, @PathParam("size") Integer pageSize) {
//        return producerRepositoryComponent.findAll(pageNumber, pageSize);
//    }

    @GetMapping(value = "/products-number/{number}", produces = "application/json")
    public List<ProducerDto> findAllProducersByProductNumberAtLeast(@PathVariable("number") Integer productNumber) {
        return producerRepositoryComponent.findByProductsNumberAtLeast(productNumber);
    }

    @GetMapping(value = "/by-product-price/{minPrice}", produces = "application/json")
    public List<ProducerDto> findAllProducersByProductMinPrice(@PathVariable("minPrice") Integer minPrice) {
        return producerRepositoryComponent.findByProductMinPrice(minPrice);
    }
}

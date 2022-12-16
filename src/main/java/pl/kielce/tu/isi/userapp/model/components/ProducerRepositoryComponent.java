package pl.kielce.tu.isi.userapp.model.components;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import pl.kielce.tu.isi.userapp.model.dao.ProducerRepository;
import pl.kielce.tu.isi.userapp.model.dto.ProducerDto;
import pl.kielce.tu.isi.userapp.model.entities.Producer;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProducerRepositoryComponent {

    private final ProducerRepository producerRepository;

    public ProducerDto saveProducer(ProducerDto producerDto) {
        Producer producer = producerRepository.save(producerDto.createEntity());
        return new ProducerDto(producer);
    }

    public List<ProducerDto> findAll() {
        return producerRepository.findAll().stream()
                .map(ProducerDto::new)
                .collect(Collectors.toList());
    }

//    public List<ProducerDto> findAll(Integer pageNumber, Integer pageSize) {
//        return producerRepository.findAll(PageRequest.of(pageNumber, pageSize)).stream()
//                .map(ProducerDto::new)
//                .collect(Collectors.toList());
//    }

    public List<ProducerDto> findByProductsNumberAtLeast(Integer productsNumber) {
        return producerRepository.findAll().stream()
                .filter(producer -> producer.getProductList().size() >= productsNumber)
                .map(ProducerDto::new)
                .collect(Collectors.toList());
    }

    public List<ProducerDto> findByProductMinPrice(Integer minPrice) {
        return producerRepository.findByProductListPriceGreaterThat(minPrice.floatValue()).stream()
                .map(ProducerDto::new)
                .collect(Collectors.toList());
    }
}

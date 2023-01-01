package pl.kielce.tu.isi.userapp.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kielce.tu.isi.userapp.model.entities.Producer;
import pl.kielce.tu.isi.userapp.model.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ProducerDto {

    private Long id;

    private String name;
    private String nip;
    private List<Long> productList;


    public Producer createEntity() {
        Producer producer = new Producer();
        producer.setName(this.name);
        producer.setNip(this.nip);
        producer.setProductList(new ArrayList<>());
        return producer;
    }

    public ProducerDto(Producer producer) {
        this.id = producer.getId();
        this.name = producer.getName();
        this.nip = producer.getNip();
        this.productList = producer.getProductList().stream().map(Product::getId).collect(Collectors.toList());
    }

}

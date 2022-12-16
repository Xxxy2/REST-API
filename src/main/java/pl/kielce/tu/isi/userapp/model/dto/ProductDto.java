package pl.kielce.tu.isi.userapp.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kielce.tu.isi.userapp.model.entities.Producer;
import pl.kielce.tu.isi.userapp.model.entities.Product;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;

    private String name;
    private Long amount;
    private Float price;

    private Long idProducer;


    public Product createEntity() {

        Producer producer = new Producer();
        producer.setId(this.idProducer);

        Product product = new Product();
        product.setName(this.name);
        product.setAmount(this.amount);
        product.setPrice(this.price);
        product.setProducer(producer);
        return product;
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.amount = product.getAmount();
        this.price = product.getPrice();
        this.idProducer = product.getProducer().getId();
    }

    public Product updateEntity(ProductDto productDto, long newId) {

        Producer producer = new Producer();
        producer.setId(this.idProducer);

        Product product = new Product();
        product.setId(newId);
        product.setName(productDto.getName());
        product.setAmount(productDto.getAmount());
        product.setPrice(productDto.getPrice());

        product.setProducer(producer);

        return product;
    }
}

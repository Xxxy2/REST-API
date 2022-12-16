package pl.kielce.tu.isi.userapp.model.components;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kielce.tu.isi.userapp.model.dao.ProductRepository;
import pl.kielce.tu.isi.userapp.model.dto.ProductDto;
import pl.kielce.tu.isi.userapp.model.entities.Product;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class ProductRepositoryComponent {

    private final ProductRepository productRepository;

    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productRepository.save(productDto.createEntity());
        return new ProductDto(product);
    }

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(product -> new ProductDto(product))
                .collect(Collectors.toList());
    }

//    public List<ProductDto> findAll(Integer pageNumber, Integer pageSize) {
//        return productRepository.findAll(PageRequest.of(pageNumber, pageSize)).stream()
//                .map(product -> new ProductDto(product))
//                .collect(Collectors.toList());
//    }

    public List<ProductDto> findAllByPriceBetween(Long minPrice, Long maxPrice) {
        return productRepository.findByPriceBetween(minPrice.floatValue(), maxPrice.floatValue()).stream()
                .map(product -> new ProductDto(product))
                .collect(Collectors.toList());
    }

    public List<ProductDto> findByProducerNipLike(String nipLike) {
        return productRepository.findByProducerNipLike(String.format("%%%s%%", nipLike)).stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public Stream<ProductDto> findById(long prodId) {

        return productRepository.findById(prodId).stream().map(ProductDto::new);
    }


    public Stream<ProductDto> findByName(String prodName) {

        return productRepository.findByName(prodName).stream().map(ProductDto::new);
    }

    public ProductDto updateProduct(ProductDto productDto, long id) {
        Product product = productRepository.save(productDto.updateEntity(productDto,id));
        return new ProductDto(product);
    }

}

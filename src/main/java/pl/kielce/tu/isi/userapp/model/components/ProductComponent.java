package pl.kielce.tu.isi.userapp.model.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kielce.tu.isi.userapp.model.dao.ProductDao;
import pl.kielce.tu.isi.userapp.model.dto.ProductDto;
import pl.kielce.tu.isi.userapp.model.entities.Product;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductComponent {

    private final ProductDao productDao;

    @Autowired
    public ProductComponent(ProductDao productDao) {
        this.productDao = productDao;
    }
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productDao.save(productDto.createEntity());
        return new ProductDto(product);
    }

    public List<ProductDto> findAll() {
        return productDao.findAll().stream()
                .map(product -> new ProductDto(product))
                .collect(Collectors.toList());
    }

    public List<ProductDto> findAllByPriceBetween(Long minPrice, Long maxPrice) {
        return productDao.findByPriceBetween(minPrice.floatValue(), maxPrice.floatValue()).stream()
                .map(product -> new ProductDto(product))
                .collect(Collectors.toList());
    }

}

package pl.kielce.tu.isi.userapp.restcontrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.isi.userapp.model.components.ProductRepositoryComponent;
import pl.kielce.tu.isi.userapp.model.dto.ProductDto;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductRepositoryComponent productRepositoryComponent;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ProductDto saveProduct(@RequestBody ProductDto productDto) {
        return productRepositoryComponent.saveProduct(productDto);
    }

    @GetMapping(value = "all", produces = "application/json")
    public List<ProductDto> findAllProducts() {
        return productRepositoryComponent.findAll();
    }

//    @GetMapping(produces = "application/json")
//    public List<ProductDto> findAllProductsWithPagination(@PathParam("page") Integer pageNumber, @PathParam("size") Integer pageSize) {
//        return productRepositoryComponent.findAll(pageNumber, pageSize);
//    }

    @GetMapping(value = "/by-price/{minPrice}/{maxPrice}", produces = "application/json")
    public List<ProductDto> findProductsByPriceBetween(@PathVariable("minPrice") Long minPrice, @PathVariable("maxPrice") Long maxPrice) {
        return productRepositoryComponent.findAllByPriceBetween(minPrice, maxPrice);
    }

    @GetMapping(value = "/producer-nip/{nipLike}", produces = "application/json")
    public List<ProductDto> findByProducerNipLike(@PathVariable("nipLike") String nipLike) {
        return productRepositoryComponent.findByProducerNipLike(nipLike);
    }

    @GetMapping(value = "/{prodId}", produces = "application/json")
    public Stream<ProductDto> findById(@PathVariable("prodId") long prodId) {
        return productRepositoryComponent.findById(prodId);
    }

    @GetMapping(value = "/s/{prodName}", produces = "application/json")
    public Stream<ProductDto> findByName(@PathVariable("prodName") String prodName) {
        return productRepositoryComponent.findByName(prodName);
    }


    @PutMapping(value = "/{id}")
    public void update(@PathVariable( "id" ) Long id, @RequestBody ProductDto productDto) {
        productRepositoryComponent.updateProduct(productDto,id);
    }
}

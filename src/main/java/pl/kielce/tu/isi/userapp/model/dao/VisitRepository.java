package pl.kielce.tu.isi.userapp.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kielce.tu.isi.userapp.model.entities.Producer;
import pl.kielce.tu.isi.userapp.model.entities.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query("SELECT p FROM Product p WHERE p.price >= ?1 AND p.price < ?2")
    List<Product> findByPriceBetween(float minPrice, float maxPrice);

    List<Product> findByProducerNipLike(String nip);
    Optional<Product> findById(Long prodId);

    Optional<Product> findByName(String prodName);
}

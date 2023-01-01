package pl.kielce.tu.isi.userapp.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kielce.tu.isi.userapp.model.entities.Product;
import pl.kielce.tu.isi.userapp.model.entities.Visit;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

//    @Query("SELECT p FROM Product p WHERE p.price >= ?1 AND p.price < ?2")
  //  List<Product> findByPriceBetween(float minPrice, float maxPrice);

 //   List<Product> findByProducerNipLike(String nip);
    Optional<Visit> findById(Long visitId);

   // Optional<Visit> findByName(String prodName);
}

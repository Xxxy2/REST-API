package pl.kielce.tu.isi.userapp.model.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kielce.tu.isi.userapp.model.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Slf4j
public class ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Product save(Product product) {
        entityManager.persist(product);
        log.info("Product [{}] added to database", product.getId());
        return product;
    }

    public List<Product> findAll() {
        Query namedQuery = entityManager.createNamedQuery("Product.findAll");
        List<Product> resultList = namedQuery.getResultList();
        log.info("Got {} products", resultList.size());
        return resultList;
    }

    public List<Product> findByPriceBetween(Float minPrice, Float maxPrice) {
        Query namedQuery = entityManager.createNamedQuery("Product.findByPriceBetween");
        namedQuery.setParameter("minPrice", minPrice);
        namedQuery.setParameter("maxPrice", maxPrice);

        List<Product> resultList = namedQuery.getResultList();
        log.info("Got {} products with the price between {} and {}", resultList.size(), minPrice, maxPrice);
        return resultList;
    }

}

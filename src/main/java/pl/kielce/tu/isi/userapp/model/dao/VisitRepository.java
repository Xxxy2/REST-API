package pl.kielce.tu.isi.userapp.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kielce.tu.isi.userapp.model.entities.Producer;
import pl.kielce.tu.isi.userapp.model.entities.Product;
import pl.kielce.tu.isi.userapp.model.entities.Visit;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    Optional<Visit> findById(Long visitId);

    @Query("SELECT DISTINCT v FROM Visit v  WHERE v.doctor.id = ?1 AND v.visitStatus = ?2")
    List<Visit> findVisitsByDoctor_IdAndVisitStatus(Long doctor_id, String visitStatus);

    @Query("SELECT COUNT(v.id)  FROM Visit v  WHERE v.doctor.id = ?1 AND v.visitStatus = ?2")
    Long countVisitsByDoctor_IdAndVisitStatus(Long doctor_id, String visitStatus);


   // List<Visit> findDoctorByName(String doctorName);

    // Optional<Visit> findByName(String prodName);
}

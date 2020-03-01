package testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testproject.model.Skok;

import java.util.List;

@Repository
public interface SkokRepository extends JpaRepository<Skok, Long> {

    List<Skok> findByTakmicarId(Long takmicarId);
}

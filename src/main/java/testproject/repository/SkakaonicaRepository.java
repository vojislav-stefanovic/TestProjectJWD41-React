package testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testproject.model.Skakaonica;

@Repository
public interface SkakaonicaRepository extends JpaRepository<Skakaonica, Long> {
}

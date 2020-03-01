package testproject.service;

import testproject.model.Skakaonica;

import java.util.List;
import java.util.Optional;

public interface SkakaonicaService {

    List<Skakaonica> findAll();

    Optional<Skakaonica> findById(Long id);

    Skakaonica save(Skakaonica skakaonica);

}

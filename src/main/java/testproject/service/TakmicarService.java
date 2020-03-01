package testproject.service;

import org.springframework.data.domain.Page;
import testproject.model.Takmicar;

import java.util.Optional;

public interface TakmicarService {

    Optional<Takmicar> findById(Long id);

    Takmicar save(Takmicar t);

    Optional<Takmicar> delete(Long id);

    Page<Takmicar> findAll(int page);

    Page<Takmicar> pretraga(String imeIprezime, String drzava, Integer minGodiste, Integer maxGodiste, int page);
}

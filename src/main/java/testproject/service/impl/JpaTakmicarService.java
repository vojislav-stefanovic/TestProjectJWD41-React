package testproject.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import testproject.model.Takmicar;
import testproject.repository.TakmicarRepository;
import testproject.service.TakmicarService;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JpaTakmicarService implements TakmicarService {

    private @NonNull TakmicarRepository takmicarRepository;

    @Override
    public Optional<Takmicar> findById(Long id) {
        return takmicarRepository.findById(id);
    }

    @Override
    public Takmicar save(Takmicar t) {
        return takmicarRepository.save(t);
    }

    @Override
    public Optional<Takmicar> delete(Long id) {
        Optional<Takmicar> takmicar = takmicarRepository.findById(id);
        takmicarRepository.deleteById(id);
        return takmicar;

    }

    @Override
    public Page<Takmicar> findAll(int page) {
        return takmicarRepository.findAll(new PageRequest(page, 6));
    }

    @Override
    public Page<Takmicar> pretraga(String imeIprezime, String drzava, Integer minGodiste, Integer maxGodiste,
                                   int page) {
        if (imeIprezime != null) {
            imeIprezime = "%" + imeIprezime + "%";
        }
        if (drzava != null) {
            drzava = "%" + drzava + "%";
        }
        return takmicarRepository.pretraga(imeIprezime, drzava, minGodiste, maxGodiste, new PageRequest(page, 6));
    }
}

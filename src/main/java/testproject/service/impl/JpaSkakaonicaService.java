package testproject.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testproject.model.Skakaonica;
import testproject.repository.SkakaonicaRepository;
import testproject.service.SkakaonicaService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JpaSkakaonicaService implements SkakaonicaService {

    private @NonNull SkakaonicaRepository skakaonicaRepository;

    @Override
    public List<Skakaonica> findAll() {
        return skakaonicaRepository.findAll();
    }

    @Override
    public Optional<Skakaonica> findById(Long id) {
        return skakaonicaRepository.findById(id);
    }

    @Override
    public Skakaonica save(Skakaonica skakaonica) {
        return skakaonicaRepository.save(skakaonica);
    }
}

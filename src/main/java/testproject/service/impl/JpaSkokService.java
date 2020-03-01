package testproject.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testproject.model.Skok;
import testproject.model.Takmicar;
import testproject.repository.SkokRepository;
import testproject.repository.TakmicarRepository;
import testproject.service.SkokService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JpaSkokService implements SkokService {

    private @NonNull TakmicarRepository takmicarRepository;
    private @NonNull SkokRepository skokRepository;

    @Override
    public List<Skok> findAll() {
        return skokRepository.findAll();
    }

    @Override
    public Skok save(Skok skok) {
        return skokRepository.save(skok);
    }

    @Override
    public List<Skok> findByTakmicarId(Long takmicarId) {
        return skokRepository.findByTakmicarId(takmicarId);
    }

    @Override
    public Skok skok(Long id, Double sudija1, Double sudija2, Double sudija3, Double sudija4, Double sudija5,
                     Double daljina) {

        Double prosecnaOcena;

        List<Double> ocene = new ArrayList<>();
        ocene.add(sudija1);
        ocene.add(sudija2);
        ocene.add(sudija3);
        ocene.add(sudija4);
        ocene.add(sudija5);
        ocene.remove(Collections.min(ocene));
        ocene.remove(Collections.max(ocene));

        Double ukupno = 0.0;
        for (Double d : ocene) {
            ukupno += d;
        }
        prosecnaOcena = ukupno / ocene.size();

        if (id == null) {
            throw new IllegalArgumentException("Id ne moze biti null");
        }
        Optional<Takmicar> takmicar = takmicarRepository.findById(id);
        if (takmicar != null) {
            Takmicar t = takmicar.get();
            Double poeniZaDaljinu = 0.0;
            if (daljina.equals(t.getSkakaonica().getK())) {
                poeniZaDaljinu = 60.0;
            } else {
                Double razlika = daljina - t.getSkakaonica().getK();
                if (razlika > 0) {
                    poeniZaDaljinu = 60.0 + (t.getSkakaonica().getD() * razlika);
                } else if (razlika < 0) {
                    razlika = razlika * -1;
                    poeniZaDaljinu = 60.0 - (t.getSkakaonica().getD() * razlika);
                }

            }
            Double zbir = poeniZaDaljinu + prosecnaOcena;
            Skok skok = new Skok();
            skok.setOcenasudija(prosecnaOcena);
            skok.setDaljina(daljina);
            skok.setTakmicar(t);
            skok.setPoeniZaDaljinu(poeniZaDaljinu);
            skok.setZbirPoena(zbir);
            t.addSkok(skok);

            skokRepository.save(skok);
            takmicarRepository.save(t);

            return skok;
        } else {
            throw new IllegalArgumentException("Ne postoji takmicar sa tim id-om");
        }

    }
}

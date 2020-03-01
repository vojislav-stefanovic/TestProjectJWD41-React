package testproject;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testproject.model.Skakaonica;
import testproject.model.Takmicar;
import testproject.service.SkakaonicaService;
import testproject.service.TakmicarService;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestData {

    private @NonNull TakmicarService takmicarService;
    private @NonNull SkakaonicaService skakaonicaService;

    @PostConstruct
    public void init() {

        Skakaonica s1 = Skakaonica.builder().naziv("Skakaonica1").k(85.0).d(1.2).build();
        Skakaonica s2 = Skakaonica.builder().naziv("Skakaonica2").k(90.0).d(1.4).build();

        skakaonicaService.save(s1);
        skakaonicaService.save(s2);

        Takmicar t1 = Takmicar.builder().
                drzava("Finska").email("oli@mail.com").godinaRodjenja(1987).
                imeIprezime("Hari Oli").visina(192.0).skakaonica(s1).build();
        Takmicar t2 = Takmicar.builder().
                drzava("Nemacka").email("martin@mail.com").godinaRodjenja(1989).
                imeIprezime("Martin Smit").visina(193.0).skakaonica(s2).build();
        Takmicar t3 = Takmicar.builder().
                drzava("Austrija").email("sep@mail.com").godinaRodjenja(1987).
                imeIprezime("Sep Brandl").visina(187.0).skakaonica(s1).build();
        Takmicar t4 = Takmicar.builder().
                drzava("Slovacka").email("jakub@gmail.com").godinaRodjenja(1993).
                imeIprezime("Jakub Banda").visina(177.0).skakaonica(s1).build();
        Takmicar t5 = Takmicar.builder().
                drzava("Finska").email("jane@mail.com").godinaRodjenja(1992).
                imeIprezime("Jane Ahonen").visina(183.0).skakaonica(s2).build();

        takmicarService.save(t1);
        takmicarService.save(t2);
        takmicarService.save(t3);
        takmicarService.save(t4);
        takmicarService.save(t5);

        skakaonicaService.save(s1);
        skakaonicaService.save(s2);


    }
}

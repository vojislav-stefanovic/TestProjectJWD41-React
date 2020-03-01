package testproject.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import testproject.model.Takmicar;
import testproject.web.dto.SkakaonicaDTO;
import testproject.web.dto.TakmicarDTO;

@Component
public class TakmicarToTakmicarDTO implements Converter<Takmicar, TakmicarDTO> {

    @Override
    public TakmicarDTO convert(Takmicar takmicar) {

        return TakmicarDTO.builder()
                .drzava(takmicar.getDrzava())
                .email(takmicar.getEmail())
                .godinaRodjenja(takmicar.getGodinaRodjenja())
                .id(takmicar.getId())
                .imeIprezime(takmicar.getImeIprezime())
                .skakaonicaDTO(new SkakaonicaDTO(takmicar.getSkakaonica()))
                .visina(takmicar.getVisina())
                .build();
    }
}

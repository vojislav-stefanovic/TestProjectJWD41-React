package testproject.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import testproject.model.Skakaonica;
import testproject.web.dto.SkakaonicaDTO;

@Component
public class SkakaonicaToSkakaonicaDTO implements Converter<Skakaonica, SkakaonicaDTO> {

    @Override
    public SkakaonicaDTO convert(Skakaonica skakaonica) {

        return SkakaonicaDTO.builder()
                .d(skakaonica.getD())
                .id(skakaonica.getId())
                .k(skakaonica.getK())
                .naziv(skakaonica.getNaziv())
                .build();
    }
}

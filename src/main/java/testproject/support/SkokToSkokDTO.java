package testproject.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import testproject.model.Skok;
import testproject.web.dto.SkokDTO;
import testproject.web.dto.TakmicarDTO;

@Component
public class SkokToSkokDTO implements Converter<Skok, SkokDTO> {

    @Override
    public SkokDTO convert(Skok skok) {

        return SkokDTO.builder()
                .daljina(skok.getDaljina())
                .id(skok.getId())
                .ocenasudija(skok.getOcenasudija())
                .poeniZaDaljinu(skok.getPoeniZaDaljinu())
                .zbirPoena(skok.getZbirPoena())
                .takmicarDTO(new TakmicarDTO(skok.getTakmicar()))
                .build();
    }
}

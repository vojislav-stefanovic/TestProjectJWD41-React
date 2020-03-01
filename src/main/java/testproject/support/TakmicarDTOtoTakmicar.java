package testproject.support;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import testproject.model.Takmicar;
import testproject.service.SkakaonicaService;
import testproject.web.dto.TakmicarDTO;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TakmicarDTOtoTakmicar implements Converter<TakmicarDTO, Takmicar> {

    private @NonNull SkakaonicaService skakaonicaService;

    @Override
    public Takmicar convert(TakmicarDTO takmicarDTO) {
        return Takmicar.builder()
                .drzava(takmicarDTO.getDrzava())
                .email(takmicarDTO.getEmail())
                .godinaRodjenja(takmicarDTO.getGodinaRodjenja())
                .id(takmicarDTO.getId())
                .imeIprezime(takmicarDTO.getImeIprezime())
                .visina(takmicarDTO.getVisina())
                .skakaonica(skakaonicaService.findById(takmicarDTO.getSkakaonicaId()).get())
                .build();
    }
}

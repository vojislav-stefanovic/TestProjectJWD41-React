package testproject.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import testproject.model.Takmicar;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TakmicarDTO {

    private Long id;
    private String imeIprezime;
    @Size(max = 35, min = 2)
    private String drzava;
    private Double visina;
    @Email
    private String email;
    private Integer godinaRodjenja;
    private SkakaonicaDTO skakaonicaDTO;
    private Long skakaonicaId;

    public TakmicarDTO(Takmicar takmicar){
        if(takmicar != null){
            this.id = takmicar.getId();
            this.imeIprezime = takmicar.getImeIprezime();
            this.drzava = takmicar.getDrzava();
            this.visina = takmicar.getVisina();
            this.email = takmicar.getEmail();
            this.godinaRodjenja = takmicar.getGodinaRodjenja();
            this.skakaonicaDTO = new SkakaonicaDTO(takmicar.getSkakaonica());
        }
    }
}

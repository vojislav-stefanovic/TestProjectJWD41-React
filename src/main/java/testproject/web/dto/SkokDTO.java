package testproject.web.dto;

import lombok.Builder;
import lombok.Data;
import testproject.model.Takmicar;

@Data
@Builder
public class SkokDTO {

    private Long id;
    private Double daljina;
    private Double poeniZaDaljinu;
    private Double ocenasudija;
    private Double zbirPoena;
    private TakmicarDTO takmicarDTO;
}

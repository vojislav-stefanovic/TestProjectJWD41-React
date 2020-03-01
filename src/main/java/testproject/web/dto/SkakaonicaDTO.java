package testproject.web.dto;

import lombok.*;
import testproject.model.Skakaonica;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkakaonicaDTO {

    private Long id;
    private String naziv;
    private Double k;
    private Double d;

    public SkakaonicaDTO(Skakaonica skakaonica){
        if(skakaonica != null){
            this.id = skakaonica.getId();
            this.naziv = skakaonica.getNaziv();
            this.k = skakaonica.getK();
            this.d = skakaonica.getD();
        }
    }
}

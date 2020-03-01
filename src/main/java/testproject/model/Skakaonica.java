package testproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "tbl_skakaonica")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Skakaonica {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(nullable = false, unique = true)
    private String naziv;
    @Column
    private Double k;
    @Column
    @DecimalMin("1.2")
    @DecimalMax("4.8")
    private Double d;

    @OneToMany(mappedBy = "skakaonica")
    private List<Takmicar> takmicari = new ArrayList<>();


    public void addTakmicar(Takmicar t) {
        this.takmicari.add(t);
        if (!this.equals(t.getSkakaonica())) {
            t.setSkakaonica(this);

        }

    }
}

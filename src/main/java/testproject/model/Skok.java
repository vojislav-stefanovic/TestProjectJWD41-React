package testproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name="tbl_skok")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Skok {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private Double daljina;
    @Column
    private Double poeniZaDaljinu;
    @Column
    private Double ocenasudija;
    @Column
    private Double zbirPoena;

    @ManyToOne(fetch = FetchType.EAGER)
    private Takmicar takmicar;


}

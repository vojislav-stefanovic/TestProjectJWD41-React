package testproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Table(name="tbl_takmicar")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Takmicar {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(nullable = false)
    private String imeIprezime;
    @Column
    private String drzava;
    @Column
    private Double visina;
    @Column(nullable = false, unique = true)
    private String email;
    @Column
    private Integer godinaRodjenja;

    @ManyToOne(fetch = FetchType.EAGER)
    private Skakaonica skakaonica;

    @OneToMany(mappedBy = "takmicar")
    private List<Skok> skokovi = new ArrayList<>();

    public void addSkok(Skok s) {
        this.skokovi.add(s);
        if (!this.equals(s.getTakmicar())) {
            s.setTakmicar(this);
        }
    }
}

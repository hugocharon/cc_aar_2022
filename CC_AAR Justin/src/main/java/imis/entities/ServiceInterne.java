package imis.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceInterne {
    @Id
    @GeneratedValue
    private Long id;
    private String nomSI;
    @ManyToOne()
    private Employe employe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomSI() {
        return nomSI;
    }

    public void setNomSI(String nomSI) {
        this.nomSI = nomSI;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}

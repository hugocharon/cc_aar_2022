package imis.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceInterne {

    @Id @GeneratedValue
    private int id;

    private String nomSI;

    @ManyToOne
    private Employe employe;

    public ServiceInterne() {
    }

    public ServiceInterne(String nomSI) {
        this.nomSI = nomSI;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

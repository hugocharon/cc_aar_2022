package imis.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Entreprise {

    @Id @GeneratedValue
    private int id;
    private String nom;
    private String siret;
    private String adresse;
    @OneToMany(mappedBy = "entreprise")
    private List<Echange> echanges;
    @OneToMany(mappedBy = "entreprise")
    private List<Vente> ventes;
    @ElementCollection
    private List<String> motCles;

    public Entreprise() {
    }

    public Entreprise(String nom, String siret, String adresse) {
        this.nom = nom;
        this.siret = siret;
        this.adresse = adresse;
        this.motCles = new ArrayList<>(List.of(this.nom));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Echange> getEchanges() {
        return echanges;
    }

    public void setEchanges(List<Echange> echanges) {
        this.echanges = echanges;
    }

    public List<Vente> getVentes() {
        return ventes;
    }

    public void setVentes(List<Vente> ventes) {
        this.ventes = ventes;
    }

    public List<String> getMotCle() {
        return motCles;
    }

    public void setMotCle(List<String> motCles) {
        this.motCles = motCles;
    }
}

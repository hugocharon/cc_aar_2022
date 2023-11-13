package imis.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Contact extends Personne {

    private String numeroTelephone;
    @ManyToMany
    private List<Echange> echanges;
    @ManyToOne
    private Entreprise entreprise;
    @ManyToOne
    private Fonction fonction;

    public Contact() {
    }

    public Contact(String nom, String prenom, String mail, String numeroTelephone) {
        super(nom, prenom, mail);
        this.numeroTelephone = numeroTelephone;
    }

    public Contact(String nom, String prenom, String mail, String numeroTelephone, Entreprise entreprise, Fonction fonction) {
        super(nom, prenom, mail);
        this.numeroTelephone = numeroTelephone;
        this.entreprise = entreprise;
        this.fonction = fonction;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public List<Echange> getEchanges() {
        return echanges;
    }

    public void setEchanges(List<Echange> echanges) {
        this.echanges = echanges;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }
}

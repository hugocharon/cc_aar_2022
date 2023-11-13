package imis.entities;

import imis.dtos.CreerContactDTO;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("CONTACT")
public class Contact extends Personne {
    @ManyToOne
    private Fonction fonction;
    private String numTelephone;
    @ManyToOne
    private Entreprise entreprise;

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

    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }

    public static Contact fromDTO(CreerContactDTO dto, Entreprise e, Fonction f) {
        Contact c = new Contact();
        c.setNumTelephone(dto.getTelephone());
        c.setNom(dto.getNom());
        c.setEmail(dto.getEmail());
        c.setPrenom(dto.getPrenom());

        c.setFonction(f);
        c.setEntreprise(e);

        return c;
    }
}

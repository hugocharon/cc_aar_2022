package imis.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vente {

    @Id @GeneratedValue
    private int id;
    private String dateVente;
    private double montant;
    private String nature;
    @ManyToOne
    private Entreprise entreprise;

    public Vente() {
    }

    public Vente(String dateVente, double montant, String nature) {
        this.dateVente = dateVente;
        this.montant = montant;
        this.nature = nature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateVente() {
        return dateVente;
    }

    public void setDateVente(String dateVente) {
        this.dateVente = dateVente;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
}

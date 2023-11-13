package imis.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Echange {

    @Id @GeneratedValue
    private int id;
    private String dateEchange;
    private String compteRendu;
    @ManyToMany
    private List<Employe> employes;
    @ManyToMany
    private List<Contact> contacts;
    @ManyToOne
    private Entreprise entreprise;

    public Echange() {
    }

    public Echange(String dateEchange, String compteRendu) {
        this.dateEchange = dateEchange;
        this.compteRendu = compteRendu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateEchange() {
        return dateEchange;
    }

    public void setDateEchange(String dateEchange) {
        this.dateEchange = dateEchange;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
}

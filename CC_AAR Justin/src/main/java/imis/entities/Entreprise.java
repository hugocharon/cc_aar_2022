package imis.entities;

import imis.dtos.CreerEntrepriseDTO;
import imis.dtos.EntrepriseDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Entreprise {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String siret;
    private String adresse;
    @OneToMany(mappedBy = "entreprise")
    private List<Vente> ventes;
    @OneToMany(mappedBy = "entreprise")
    private List<Echange> echanges;
    @OneToMany(mappedBy = "entreprise")
    private List<Contact> contacts;
    @ElementCollection
    private List<String> motscles;

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<String> getMotscles() {
        return motscles;
    }

    public void setMotscles(List<String> motscles) {
        this.motscles = motscles;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public static Entreprise creerFromDTO(CreerEntrepriseDTO dto) {
        Entreprise e = new Entreprise();
        e.setAdresse(dto.getAdresse());
        e.setNom(dto.getNom());
        e.setSiret(dto.getSiret());
        return e;
    }

    public static EntrepriseDTO toDTO(Entreprise e) {
        EntrepriseDTO dto = new EntrepriseDTO();
        dto.setAdresse(e.getAdresse());
        dto.setNom(e.getNom());
        dto.setSiret(e.getSiret());
        dto.setId(e.getId());
        return dto;
    }
}

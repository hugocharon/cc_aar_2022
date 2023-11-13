package imis.entities;

import imis.dtos.CreerFonctionDTO;
import imis.dtos.FonctionDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Fonction {
    @Id
    @GeneratedValue
    private Long idFonction;

    private String intituleFonction;

    @OneToMany(mappedBy = "fonction")
    private List<Contact> contacts;

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Long getIdFonction() {
        return idFonction;
    }

    public void setIdFonction(Long idFonction) {
        this.idFonction = idFonction;
    }

    public String getIntituleFonction() {
        return intituleFonction;
    }

    public void setIntituleFonction(String intituleFonction) {
        this.intituleFonction = intituleFonction;
    }

    public static Fonction fromDTO(CreerFonctionDTO dto) {
        Fonction f = new Fonction();
        f.setIntituleFonction(dto.getIntitule());
        return f;
    }

    public static FonctionDTO toDTO(Fonction f) {
        FonctionDTO dto = new FonctionDTO();
        dto.setIntituleFonction(f.getIntituleFonction());
        dto.setIdFunction(f.getIdFonction());
        return dto;
    }
}

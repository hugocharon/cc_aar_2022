package imis.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Fonction {

    @Id @GeneratedValue
    private int id;
    private String intituleFonction;
    @OneToMany(mappedBy = "fonction")
    private List<Contact> contacts;

    public Fonction() {
    }

    public Fonction(String intituleFonction) {
        this.intituleFonction = intituleFonction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntituleFonction() {
        return intituleFonction;
    }

    public void setIntituleFonction(String intituleFonction) {
        this.intituleFonction = intituleFonction;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}

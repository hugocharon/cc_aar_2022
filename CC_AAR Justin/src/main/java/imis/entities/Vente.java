package imis.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Vente {
    @Id
    @GeneratedValue()
    private Long id;
    private LocalDateTime dateVente;
    private Float montant;
    private String nature;
    @ManyToOne
    private Entreprise entreprise;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateVente() {
        return dateVente;
    }

    public void setDateVente(LocalDateTime dateVente) {
        this.dateVente = dateVente;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }
}

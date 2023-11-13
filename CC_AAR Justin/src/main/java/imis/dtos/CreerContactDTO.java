package imis.dtos;

public class CreerContactDTO {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private Long entreprise;
    private Long fonction;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Long entreprise) {
        this.entreprise = entreprise;
    }

    public Long getFonction() {
        return fonction;
    }

    public void setFonction(Long fonction) {
        this.fonction = fonction;
    }
}

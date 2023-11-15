package imis.services;

import imis.dtos.*;
import imis.entities.Contact;
import imis.entities.Entreprise;
import imis.entities.Fonction;
import imis.exceptions.CreerContactParamException;
import imis.exceptions.EntrepriseNotFoundException;
import imis.exceptions.FonctionNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Facade {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void creerEntreprise(CreerEntrepriseDTO creerEntrepriseDTO) {
        em.persist(Entreprise.creerFromDTO(creerEntrepriseDTO));
    }

    @Transactional
    public void creerFonction(CreerFonctionDTO creerFonctionDTO) {
        em.persist(Fonction.fromDTO(creerFonctionDTO));
    }

    @Transactional
    public void creerContact(CreerContactDTO creerContactDTO) throws EntrepriseNotFoundException, FonctionNotFoundException, CreerContactParamException {
        if(creerContactDTO.getEntreprise() == null || creerContactDTO.getFonction() == null || creerContactDTO.getNom().isEmpty())
            throw new CreerContactParamException();

        Entreprise e = em.find(Entreprise.class, creerContactDTO.getEntreprise());
        if(e == null)
            throw new EntrepriseNotFoundException();

        Fonction f = em.find(Fonction.class, creerContactDTO.getFonction());
        if(f == null)
            throw new FonctionNotFoundException();

        em.persist(Contact.fromDTO(creerContactDTO, e, f));
    }

    public List<FonctionDTO> getFonctions() {
        Query q = em.createQuery("select f from Fonction f");
        List<Fonction> fonctions = q.getResultList();
        return fonctions.stream().map(Fonction::toDTO).collect(Collectors.toList());
    }

    public EntrepriseDTO getEntreprisePlusContact() {
        Query q = em.createQuery("SELECT e FROM Entreprise e " +
                        "LEFT JOIN FETCH e.contacts c " +
                        "GROUP BY c " +
                        "ORDER BY COUNT(c) DESC", Entreprise.class)
                .setMaxResults(1);
        Entreprise e = (Entreprise) q.getSingleResult();
        return Entreprise.toDTO(e);
    }

    public List<EntrepriseDTO> getEntreprises() {
        Query q = em.createQuery("select e from Entreprise e");
        List<Entreprise> entreprises = q.getResultList();
        return entreprises.stream().map(Entreprise::toDTO).collect(Collectors.toList());
    }

    public List<EntrepriseDTO> getEntrepriseParMotCles(String motcle) {

        Query query = em.createQuery(
                        "SELECT e FROM Entreprise e " +
                                "WHERE upper(:motsCles) MEMBER OF e.motscles", Entreprise.class)
                .setParameter("motsCles", motcle);

        List<Entreprise> entreprises = query.getResultList();
        return entreprises.stream().map(Entreprise::toDTO).collect(Collectors.toList());
    }
}

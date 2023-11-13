package imis.services;


import imis.entities.Contact;
import imis.entities.Entreprise;
import imis.entities.Fonction;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class Facade {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createEntreprise(String siret, String nom, String adresse) {
        Entreprise e = new Entreprise(nom, siret, adresse);
        em.persist(e);
    }

    @Transactional
    public void createFonction(String intitule) {
        Fonction f = new Fonction(intitule);
        em.persist(f);
    }

    @Transactional
    public void creerContact(String nom, String prenom, String mail, String tel, String entreprise, String fonction) {
        Query qf = em.createQuery("SELECT f FROM Fonction f WHERE f.id = :fonction");
        qf.setParameter("fonction", Integer.parseInt(fonction));
        Fonction f = (Fonction) qf.getSingleResult();

        Query qe = em.createQuery("SELECT e FROM Entreprise e WHERE e.siret = :entreprise");
        qe.setParameter("entreprise", entreprise);
        Entreprise e = (Entreprise) qe.getSingleResult();



        Contact c = new Contact(nom, prenom, mail, tel, e, f);
        em.persist(c);
    }

    public List<Entreprise> getAllEntreprise() {
        try {
            Query q = em.createQuery("SELECT e FROM Entreprise e");
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Fonction> getAllFonction() {
        try {
            Query q = em.createQuery("SELECT f FROM Fonction f");
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }


    public Entreprise getEntrepriseAvecLePlusDeContact() {
        try {
            Query q = em.createQuery("SELECT e FROM Entreprise e JOIN Contact c ON c.entreprise = e GROUP BY e ORDER BY COUNT(c) DESC");
            q.setMaxResults(1);
            Entreprise e = (Entreprise) q.getSingleResult();
            return e;
        } catch (Exception e) {
            return null;
        }
    }


    public List<Entreprise> getEntrepriseParMotCle(String motcle) {
        try {
            Query q = em.createQuery("SELECT e FROM Entreprise e WHERE :motcle MEMBER OF e.motCles");
            q.setParameter("motcle", motcle);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
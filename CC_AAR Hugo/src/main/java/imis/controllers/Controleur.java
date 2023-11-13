package imis.controllers;

import imis.entities.Entreprise;
import imis.entities.Fonction;
import imis.services.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("")
public class Controleur {
    @Autowired
    Facade facade;

    @RequestMapping("")
    public String root(){
        return "hello";
    }

    @GetMapping("createEntreprise")
    public String createEntrepriseGet(){
        return "createEntreprise";
    }

    @PostMapping("createEntreprise")
    public String createEntreprisePost(@RequestParam String siret, @RequestParam String nom, @RequestParam String adresse) {
        facade.createEntreprise(siret,nom,adresse);
        return "hello";
    }

    @GetMapping("createFonction")
    public String createFonctionGet(){
        return "createFonction";
    }

    @PostMapping("createFonction")
    public String createFonctionPost(@RequestParam String intitule){
        facade.createFonction(intitule);
        return "hello";
    }

    @GetMapping("createContact")
    public String createContactGet(Model model){

        List<Fonction> fonctions = facade.getAllFonction();
        List<Entreprise> entreprises = facade.getAllEntreprise();

        model.addAttribute("entreprises",entreprises);
        model.addAttribute("fonctions",fonctions);

        return "createContact";
    }

    @PostMapping("createContact")
    public String createContactPost(@RequestParam String nom, @RequestParam String prenom, @RequestParam String email, @RequestParam String telephone, @RequestParam String entreprise, @RequestParam String fonction){
        facade.creerContact(nom,prenom,email,telephone,entreprise,fonction);
        return "hello";
    }

    @GetMapping("plusContact")
    public String plusContact(Model model){
        Entreprise entreprise = facade.getEntrepriseAvecLePlusDeContact();

        if(entreprise == null) {
            model.addAttribute("error", "Aucune entreprise existante !");
            return "plusContact";
        } else {
            model.addAttribute("e", entreprise);
            return "plusContact";
        }
    }

    @PostMapping("parMotCle")
    public String parMotCle(Model model, @RequestParam String motcle){
        if(Objects.isNull(motcle) || facade.getEntrepriseParMotCle(motcle) == null) {
            return "hello";
        }

        List<Entreprise> entreprises = facade.getEntrepriseParMotCle(motcle);

        model.addAttribute("motcle", motcle);
        model.addAttribute("entreprises", entreprises);

        return "entreprises";
    }
}

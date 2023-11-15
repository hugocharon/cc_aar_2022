package imis.controllers;

import imis.entities.Entreprise;
import imis.entities.Fonction;
import imis.exceptions.FonctionInexistante;
import imis.exceptions.ParametreVideException;
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

import javax.validation.Valid;
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
    public String createEntreprisePost(@Valid @ModelAttribute Entreprise entreprise, BindingResult result, Model model) {
        try {
            facade.createEntreprise(entreprise.getSiret(), entreprise.getNom(), entreprise.getAdresse());
            return "hello";
        } catch (ParametreVideException e) {
            result.addError(new ObjectError("entreprise", "Un des paramètres est vide !"));
            return "createEntreprise";
        }
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

    @GetMapping("getFonction")
    public String getFonction(Model model){
        List<Fonction> fonctions = facade.getAllFonction();
        model.addAttribute("fonctions",fonctions);
        return "getFonction";
    }

    @GetMapping("updateFonction")
    public String updateFonction(Model model) {
        List<Fonction> fonctions = facade.getAllFonction();
        model.addAttribute("fonctions",fonctions);
        return "updateFonction";
    }

    @PostMapping("updateFonction")
    public String updateFonction(@RequestParam String id, @RequestParam String intitule, Model model){
        try {
            model.addAttribute("updateFonction", true);
            facade.updateFonction(id, intitule);
            return "hello";
        } catch (FonctionInexistante e) {
            model.addAttribute("updateFonction", false);
            return "hello";
        }
    }

    @PostMapping("deleteFonction")
    public String deleteFonction(@RequestParam String id, Model model){
        try {
            facade.deleteFonction(id);
            model.addAttribute("deleteFonction", true);
            return "hello";
        } catch (FonctionInexistante e) {
            model.addAttribute("deleteFonction", false);
            return "hello";
        }
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

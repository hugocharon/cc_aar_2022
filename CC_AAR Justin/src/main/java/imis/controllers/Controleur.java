package imis.controllers;

import imis.dtos.CreerContactDTO;
import imis.dtos.CreerEntrepriseDTO;
import imis.dtos.CreerFonctionDTO;
import imis.dtos.SearchActionDTO;
import imis.exceptions.CreerContactParamException;
import imis.exceptions.EntrepriseNotFoundException;
import imis.exceptions.FonctionNotFoundException;
import imis.services.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("")
public class Controleur {
    @Autowired
    Facade facade;

    @RequestMapping("")
    public String root(Model model){
        initSearchAction(model);
        return "hello";
    }

    private void initSearchAction(Model model) {
        model.addAttribute("search", new SearchActionDTO());
    }

    @GetMapping("createEntreprise")
    public String createEntrepriseGet(){
        return "createEntreprise";
    }

    @PostMapping("createEntreprise")
    public String createEntreprisePost(CreerEntrepriseDTO dto, Model model) {
        facade.creerEntreprise(dto);
        initSearchAction(model);
        return "hello";
    }

    @GetMapping("createFonction")
    public String createFonctionGet(){
        return "createFonction";
    }

    @PostMapping("createFonction")
    public String createFonctionPost(CreerFonctionDTO dto, Model model){
        // TODO ajouter les paramètres de la méthode
        // TODO créer la méthode dans la facade
        facade.creerFonction(dto);
        initSearchAction(model);
        return "hello";
    }

    @GetMapping("createContact")
    public String createContactGet(Model model){
        // TODO aller chercher la liste des entreprises et des fonctions dans la facade
        // TODO les ajouter dans le modèle
        model.addAttribute("entreprises", facade.getEntreprises());
        model.addAttribute("fonctions", facade.getFonctions());
        return "createContact";
    }

    @PostMapping("createContact")
    public String createContactPost(CreerContactDTO dto, BindingResult result, Model model){
        // TODO ajouter les paramètres de la méthode
        // TODO créer la méthode dans la facade
        try {
            facade.creerContact(dto);
            initSearchAction(model);
            return "hello";
        } catch (EntrepriseNotFoundException e) {
            result.addError(new ObjectError("entreprise","L'entreprise n'existe pas."));
        } catch (FonctionNotFoundException e) {
            result.addError(new ObjectError("fonction","La fonction n'existe pas."));
        } catch (CreerContactParamException e) {
            result.addError(new ObjectError("incorrect","Veuilles renseigner toutes les informations."));
        }
        return "createContact";
    }

    @GetMapping("plusContact")
    public String plusContact(Model model){
        // TODO devinez...
        model.addAttribute("entreprise", facade.getEntreprisePlusContact());
        return "plusContact";
    }

    @GetMapping("parMotCle")
    public String parMotCle(@RequestParam String motcle,Model model){
        // TODO devinez...
        model.addAttribute("motcle", motcle);
        model.addAttribute("entreprises", facade.getEntrepriseParMotCles(motcle));
        return "entreprises";
    }
}

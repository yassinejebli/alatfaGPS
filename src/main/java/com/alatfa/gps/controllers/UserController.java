package com.alatfa.gps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 */
@Controller
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("titre", "Tableau de bord");
        return "index";
    }

    @RequestMapping(value = "/Vehicule", method = RequestMethod.GET)
    public String vehicule(Model model) {
        model.addAttribute("titre", "Gestion des véhicules");
        return "vehicule";
    }

    @RequestMapping(value = "/Historique", method = RequestMethod.GET)
    public String historique(Model model) {
        model.addAttribute("titre", "Trajets");
        return "historique";
    }

    @RequestMapping(value = "/PointInteret", method = RequestMethod.GET)
    public String pointInteret(Model model) {
        model.addAttribute("titre", "Gestion des points d'intérêts");
        return "pointInteret";
    }

    @RequestMapping(value = "/Chauffeur", method = RequestMethod.GET)
    public String chauffeur(Model model) {
        model.addAttribute("titre", "Gestion des chauffeurs");
        return "chauffeur";
    }


    //juste pour le test (mode dev)
    @RequestMapping(value = "/Position", method = RequestMethod.GET)
    public String position(Model model) {
        model.addAttribute("titre", "Gestion des positions");
        return "position";
    }

    @RequestMapping(value = "/GeoZoneLimit", method = RequestMethod.GET)
    public String geoZoneLimit(Model model) {
        model.addAttribute("titre", "Gestion des zones d'actions");
        return "geoZoneLimit";
    }

    @RequestMapping(value = "/GeoZoneAlert", method = RequestMethod.GET)
    public String geoZoneAlert(Model model) {
        model.addAttribute("titre", "Gestion des zone d'alertes");
        return "geoZoneAlert";
    }

    @RequestMapping(value = "/Icon", method = RequestMethod.GET)
    public String icon(Model model) {
        model.addAttribute("titre", "Gestion des icones de la carte");
        return "icon";
    }

    @RequestMapping(value = "/Notification", method = RequestMethod.GET)
    public String notification(Model model) {
        model.addAttribute("titre", "Consultation des notifications");
        return "notification";
    }

    @RequestMapping(value = "/Suivi", method = RequestMethod.GET)
    public String suivi(Model model) {
        model.addAttribute("titre", "Suivi des véhicules en temps réel");
        return "suivi";
    }

    @RequestMapping(value = "/EquipementGps", method = RequestMethod.GET)
    public String equipementGps(Model model) {
        model.addAttribute("titre", "Gestion des equipements GPS");
        return "equipementGps";
    }


    @RequestMapping(value = "/Mission", method = RequestMethod.GET)
    public String mission(Model model) {
        model.addAttribute("titre", "Gestion des missions");
        return "mission";
    }

    @RequestMapping(value = "/Statistique", method = RequestMethod.GET)
    public String tableauBord(Model model) {
        model.addAttribute("titre", "Statistques");
        return "statistique";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }





}

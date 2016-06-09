package com.alatfa.gps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by UNKNOWN on 21/04/2016.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/Vehicule", method = RequestMethod.GET)
    public String vehicule(Model model) {
        return "vehicule";
    }

    @RequestMapping(value = "/Historique", method = RequestMethod.GET)
    public String historique(Model model) {
        return "historique";
    }

    @RequestMapping(value = "/PointInteret", method = RequestMethod.GET)
    public String pointInteret(Model model) {
        return "pointInteret";
    }

    @RequestMapping(value = "/Chauffeur", method = RequestMethod.GET)
    public String chauffeur(Model model) {
        return "chauffeur";
    }
    
    @RequestMapping(value = "/Position", method = RequestMethod.GET)
    public String position(Model model) {
        return "position";
    }

    @RequestMapping(value = "/GeoZoneLimit", method = RequestMethod.GET)
    public String geoZoneLimit(Model model) {
        return "geoZoneLimit";
    }

    @RequestMapping(value = "/GeoZoneAlert", method = RequestMethod.GET)
    public String geoZoneAlert(Model model) {
        return "geoZoneAlert";
    }

    @RequestMapping(value = "/Icon", method = RequestMethod.GET)
    public String icon(Model model) {
        return "icon";
    }

    @RequestMapping(value = "/Notification", method = RequestMethod.GET)
    public String notification(Model model) {
        return "notification";
    }

    @RequestMapping(value = "/Suivi", method = RequestMethod.GET)
    public String suivi(Model model) {
        return "suivi";
    }

    @RequestMapping(value = "/EquipementGps", method = RequestMethod.GET)
    public String equipementGps(Model model) {
        return "equipementGps";
    }


    @RequestMapping(value = "/Mission", method = RequestMethod.GET)
    public String mission(Model model) {
        return "mission";
    }

    @RequestMapping(value = "/TableauBord", method = RequestMethod.GET)
    public String tableauBord(Model model) {
        return "tableauBord";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }





}

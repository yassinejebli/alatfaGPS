package com.alatfa.gps.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by UNKNOWN on 21/04/2016.
 */
@Controller
@RequestMapping("admin")
public class AdministrationController {

    @PreAuthorize("hasAuthority('admin')")
    @RequestMapping(value = "/Utilisateur", method = RequestMethod.GET)
    public String utilisateur(Model model) {
        return "utilisateur";
    }



}

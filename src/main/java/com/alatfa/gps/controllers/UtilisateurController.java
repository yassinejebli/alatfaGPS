package com.alatfa.gps.controllers;

import com.alatfa.gps.model.Utilisateur;
import com.alatfa.gps.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 *
 */

@RestController
@RequestMapping(value = "/rest/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository repo;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<Utilisateur> getUtilisateurs() {
        return repo.findAll();
    }

    @RequestMapping(value="/getUser/{login}/{password}", method= RequestMethod.GET)
    public Utilisateur getUser(@PathVariable("login") String login,@PathVariable("password") String password)
    {
        System.out.println("looooooooogin: "+login);
        return repo.findByLoginAndPassword(login,password);
    }

    @RequestMapping(method= RequestMethod.POST)
    public Utilisateur post(@RequestBody Utilisateur objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.PUT)
    public Utilisateur put(@RequestBody Utilisateur objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }


}

package com.alatfa.gps.controllers;

import com.alatfa.gps.model.Chauffeur;
import com.alatfa.gps.repositories.ChauffeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */

@RestController
@RequestMapping(value = "/rest/chauffeurs")
public class ChauffeurController {

    @Autowired
    private ChauffeurRepository repo;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<Chauffeur> getChauffeurs() {
        return repo.findAll();
    }

    @RequestMapping(value="/getChauffeur/{id}", method= RequestMethod.GET)
    public Chauffeur getChauffeur(@PathVariable("id") String id) {
        return repo.findOne(id);
    }

    @RequestMapping(method= RequestMethod.POST)
    public Chauffeur post(@RequestBody Chauffeur objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.PUT)
    public Chauffeur put(@RequestBody Chauffeur objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }


}

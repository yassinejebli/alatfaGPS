package com.alatfa.gps.controllers;

import com.alatfa.gps.model.Vehicule;
import com.alatfa.gps.repositories.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */

@RestController
@RequestMapping(value = "/rest/vehicules")
public class VehiculeController {

    @Autowired
    private VehiculeRepository repo;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<Vehicule> getVehicules() {
        return repo.findAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Vehicule post(@RequestBody Vehicule objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.PUT)
    public Vehicule put(@RequestBody Vehicule objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }


}

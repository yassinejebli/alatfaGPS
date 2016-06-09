package com.alatfa.gps.controllers;

import com.alatfa.gps.model.EquipementGps;
import com.alatfa.gps.repositories.EquipementGpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */

@RestController
@RequestMapping(value = "/rest/equipementGpss")
public class EquipementGpsController {

    @Autowired
    private EquipementGpsRepository repo;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<EquipementGps> getEquipementGpss() {
        return repo.findAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    public EquipementGps post(@RequestBody EquipementGps objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.PUT)
    public EquipementGps put(@RequestBody EquipementGps objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }


}

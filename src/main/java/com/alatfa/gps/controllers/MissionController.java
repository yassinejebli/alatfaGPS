package com.alatfa.gps.controllers;

import com.alatfa.gps.model.Mission;
import com.alatfa.gps.repositories.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */

@RestController
@RequestMapping(value = "/rest/missions")
public class MissionController {

    @Autowired
    private MissionRepository repo;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<Mission> getMissions() {
        return repo.findAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Mission post(@RequestBody Mission objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.PUT)
    public Mission put(@RequestBody Mission objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }


}

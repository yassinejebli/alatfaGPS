package com.alatfa.gps.controllers;

import com.alatfa.gps.model.PointInteret;
import com.alatfa.gps.repositories.PointInteretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */

@RestController
@RequestMapping(value = "/rest/pointInterets")
public class PointInteretController {

    @Autowired
    private PointInteretRepository repo;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<PointInteret> getPointInterets() {
        return repo.findAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    public PointInteret post(@RequestBody PointInteret objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.PUT)
    public PointInteret put(@RequestBody PointInteret objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }


}

package com.alatfa.gps.controllers;

import com.alatfa.gps.model.Icon;
import com.alatfa.gps.repositories.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */

@RestController
@RequestMapping(value = "/rest/icons")
public class IconController {

    @Autowired
    private IconRepository repo;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<Icon> getIcons() {
        return repo.findAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Icon post(@RequestBody Icon objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.PUT)
    public Icon put(@RequestBody Icon objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }


}

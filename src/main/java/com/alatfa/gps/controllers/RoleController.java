package com.alatfa.gps.controllers;

import com.alatfa.gps.model.Role;
import com.alatfa.gps.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */

@RestController
@RequestMapping(value = "/rest/roles")
public class RoleController {

    @Autowired
    private RoleRepository repo;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<Role> getRoles() {
        return repo.findAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Role post(@RequestBody Role objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.PUT)
    public Role put(@RequestBody Role objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }


}

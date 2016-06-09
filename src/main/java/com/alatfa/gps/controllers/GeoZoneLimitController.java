package com.alatfa.gps.controllers;

import com.alatfa.gps.model.GeoZoneLimit;
import com.alatfa.gps.repositories.GeoZoneLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */

@RestController
@RequestMapping(value = "/rest/geoZoneLimits")
public class GeoZoneLimitController {

    @Autowired
    private GeoZoneLimitRepository repo;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<GeoZoneLimit> getGeoZoneLimits() {
        return repo.findAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    public GeoZoneLimit post(@RequestBody GeoZoneLimit objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.PUT)
    public GeoZoneLimit put(@RequestBody GeoZoneLimit objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }


}

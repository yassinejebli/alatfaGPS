package com.alatfa.gps.controllers;

import com.alatfa.gps.model.GeoZoneAlert;
import com.alatfa.gps.repositories.GeoZoneAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */

@RestController
@RequestMapping(value = "/rest/geoZoneAlerts")
public class GeoZoneAlertController {

    @Autowired
    private GeoZoneAlertRepository repo;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<GeoZoneAlert> getGeoZoneAlerts() {
        return repo.findAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    public GeoZoneAlert post(@RequestBody GeoZoneAlert objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.PUT)
    public GeoZoneAlert put(@RequestBody GeoZoneAlert objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }


}

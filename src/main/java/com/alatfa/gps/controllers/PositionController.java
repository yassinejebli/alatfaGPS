package com.alatfa.gps.controllers;

import com.alatfa.gps.model.Position;
import com.alatfa.gps.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 */

@RestController
@RequestMapping(value = "/rest/positions")
public class PositionController {

    @Autowired
    private PositionRepository repo;
//findTopByOrderByDateDesc
    @RequestMapping(value="findTopByOrderByDateDesc", method= RequestMethod.GET)
    public Position findTopByOrderByDateDesc_() {
        return repo.findTopByOrderByDateDesc();

    }





    @RequestMapping(value="findTopByVehicule_IdOrderByDateDesc", method= RequestMethod.GET)
    public Position findTopByVehicule_IdOrderByDateDesc_(@PathParam(value="idVehicule") String idVehicule) {
        return repo.findTopByVehicule_IdOrderByDateDesc(idVehicule);

    }

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<Position> getPositions() {
        return repo.findAll();
    }

 /*   @RequestMapping(method= RequestMethod.POST)
    public DeferredResult<Position> deferredResult(@RequestBody Position objet) {
        DeferredResult<Position> result = new DeferredResult<Position>();
        repo.save(objet);
        return result;
    }*/

    @RequestMapping(method= RequestMethod.POST)
    public Position post(@RequestBody Position objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.PUT)
    public Position put(@RequestBody Position objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }



}

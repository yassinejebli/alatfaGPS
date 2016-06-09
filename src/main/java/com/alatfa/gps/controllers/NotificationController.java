package com.alatfa.gps.controllers;

import com.alatfa.gps.model.Notification;
import com.alatfa.gps.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */

@RestController
@RequestMapping(value = "/rest/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository repo;

    @RequestMapping(value="", method= RequestMethod.GET)
    public List<Notification> getNotifications() {
        return repo.findAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Notification post(@RequestBody Notification objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.PUT)
    public Notification put(@RequestBody Notification objet) {
        return repo.save(objet);
    }


    @RequestMapping(method= RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }


}

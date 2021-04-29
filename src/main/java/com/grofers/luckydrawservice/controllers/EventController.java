package com.grofers.luckydrawservice.controllers;

import com.grofers.luckydrawservice.models.Event;
import com.grofers.luckydrawservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class EventController {

    @Autowired
    private EventService eventService;


    @PostMapping("/addEvent")
    public String saveEvent(@RequestBody Event event) {
        try {
            eventService.saveEvent(event);
            return "Event saved succesfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Can't save event";
        }
    }

    @GetMapping("/getEvents")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping("/getEvent")
    public Optional<Event> getEventById(@RequestParam String eventId) {
        return eventService.getEvent(Long.parseLong(eventId));
    }

}

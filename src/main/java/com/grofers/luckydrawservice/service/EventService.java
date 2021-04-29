package com.grofers.luckydrawservice.service;

import com.grofers.luckydrawservice.models.Event;
import com.grofers.luckydrawservice.repos.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventService {

    /**
     * Service for Events handling - creating, finding events, find event by Id
     */
    @Autowired
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void saveEvent(Event event) {
        eventRepository.save(event);
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEvent(Long eventId) {
        return eventRepository.findById(eventId);
    }
}

package com.grofers.luckydrawservice.service;

import com.grofers.luckydrawservice.models.Event;
import com.grofers.luckydrawservice.models.User;
import com.grofers.luckydrawservice.repos.EventRepository;
import com.grofers.luckydrawservice.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.logging.Logger;

@Service
@Transactional
public class LuckyDrawService {

    @Autowired
    Logger logger;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository eventRepository;

    public void participateInEvent(long userId, long eventId) {
        User user = userRepository.findByUserId(userId);

        //if user has raffleTickets
        if(user.getRaffleTickets()!=0) {
            //Adding user as participants in event
            Event event = eventRepository.getEventByEventId(eventId);
            ArrayList<Long> participants = (ArrayList<Long>) event.getParticipants();
            participants.add(userId);
            event.setParticipants(participants);
            eventRepository.save(event);
            //Adding event in user's events list
            ArrayList<Long>eventsParticipated = (ArrayList<Long>) user.getEventsParticipated();
            eventsParticipated.add(eventId);
            user.setEventsParticipated(eventsParticipated);
            //Reducing raffleTickets of user by 1
            user.setRaffleTickets(user.getRaffleTickets()-1);
            userRepository.save(user);
        }
        else {
            logger.info("User don't have enough raffle tickets");
        }
    }

    public long calculateWinnerOfTheEvent(long eventId) {

        Event event = eventRepository.getEventByEventId(eventId);

        //use random function to find winner
        int max = event.getParticipants().size()-1;
        int min = 0;
        int range = max-min+1;

        int winnerIndex = (int) (Math.random()*range) + min;
        long winnerId =  event.getParticipants().get(winnerIndex);
        event.setWinnerId(winnerId);
        return winnerId;
    }

    public ArrayList<Long> getWinnersOfPastWeek() {

    }






}

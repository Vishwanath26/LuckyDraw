package com.grofers.luckydrawservice.service;

import com.grofers.luckydrawservice.DTO.NextEventTimingAndPrize;
import com.grofers.luckydrawservice.DTO.WinnersOfPastWeek;
import com.grofers.luckydrawservice.models.Event;
import com.grofers.luckydrawservice.models.User;
import com.grofers.luckydrawservice.repos.EventRepository;
import com.grofers.luckydrawservice.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LuckyDrawService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository eventRepository;

    private static final Logger logger= LoggerFactory.getLogger(LuckyDrawService.class);

    public LuckyDrawService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void getRaffleTicket(Long userId) {
        User userToGetRaffleTicket = userRepository.findByUserId(userId);
        userToGetRaffleTicket.setRaffleTickets(userToGetRaffleTicket.getRaffleTickets() + 1);
        try {
            userRepository.save(userToGetRaffleTicket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String participateInEvent(long userId, long eventId) {
        User user = userRepository.findByUserId(userId);

        //if user has raffleTickets
        if (user.getRaffleTickets() != 0) {
            //Adding user as participants in event
            Event event = eventRepository.getEventByEventId(eventId);
            List<Long> participants = event.getParticipants();
            //check if user is already a participant
            if (participants.contains(userId)) {
                return ("User is already a participant in this event");
            } else {
                participants.add(userId);
                event.setParticipants(participants);
                eventRepository.save(event);
                //Adding event in user's events list
                List<Long> eventsParticipated = user.getEventsParticipated();
                eventsParticipated.add(eventId);
                user.setEventsParticipated(eventsParticipated);
                //Reducing raffleTickets of user by 1
                user.setRaffleTickets(user.getRaffleTickets() - 1);
                userRepository.save(user);
                return ("User is successfully added as participant");
            }
        } else {
            return ("User don't have enough raffle tickets");
        }
    }

    public User calculateWinnerOfTheEvent(long eventId) {
        Event event = eventRepository.getEventByEventId(eventId);

        //In case event's winner had been calculated earlier
        if (event.getWinnerId() != null) {
            logger.info("Winner has already been calculated");
            return userRepository.findByUserId(event.getWinnerId());
        }

        //use random function on array index of participants list to find winner
        int max = event.getParticipants().size() - 1;
        int min = 0;
        int range = max - min + 1;

        int winnerIndex = (int) (Math.random() * range) + min;
        long winnerId = event.getParticipants().get(winnerIndex);
        event.setWinnerId(winnerId);
        return userRepository.findByUserId(winnerId);
    }

    public List<WinnersOfPastWeek> getWinnersOfPastWeek() {
        LocalDateTime oneWeekAgoDateTime = LocalDateTime.now().minusDays(7);

        //get all events in past week
        List<Event> eventsInPastWeek = eventRepository.findAllByEventTimingBetween(oneWeekAgoDateTime, LocalDateTime.now());
        List<WinnersOfPastWeek> winnersOfEventsInPastWeek = new ArrayList<>();
        for (Event event : eventsInPastWeek) {
            User winner = userRepository.findByUserId(event.getWinnerId());
            if (winner != null)
                winnersOfEventsInPastWeek.add(new WinnersOfPastWeek(event.getEventName(), winner.getUserName()));
        }
        if (winnersOfEventsInPastWeek.isEmpty()) {
            logger.info("No events in past week");
        }
        return winnersOfEventsInPastWeek;
    }

    public NextEventTimingAndPrize getNextEventTimingAndPrize() {

        Event nextEvent = eventRepository.findFirstEventByEventTimingAfter(LocalDateTime.now());
        LocalDateTime nextEventTiming = nextEvent.getEventTiming();
        String nextEventPrize = nextEvent.getEventPrize();
        return new NextEventTimingAndPrize(nextEventTiming, nextEventPrize);
    }

}

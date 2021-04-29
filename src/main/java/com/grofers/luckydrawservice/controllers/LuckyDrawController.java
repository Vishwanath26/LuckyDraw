package com.grofers.luckydrawservice.controllers;

import com.grofers.luckydrawservice.DTO.NextEventTimingAndPrize;
import com.grofers.luckydrawservice.DTO.WinnersOfPastWeek;
import com.grofers.luckydrawservice.models.User;
import com.grofers.luckydrawservice.service.LuckyDrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class LuckyDrawController {

    @Autowired
    private LuckyDrawService luckyDrawService;


    @GetMapping("/giveTicket")
    public String giveRaffleTicket(@RequestParam String userId) {
        try {
            luckyDrawService.getRaffleTicket(Long.parseLong(userId));
            return "Raffle Ticket allotted successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Raffle Ticket can't be allotted";
        }
    }

    @GetMapping("/nextEventTimingAndPrize")
    public NextEventTimingAndPrize getNextEventTimingAndPrize() {
        return luckyDrawService.getNextEventTimingAndPrize();
    }

    @GetMapping("/participate")
    public String participate(@RequestParam String userId, @RequestParam String eventId) {
        return luckyDrawService.participateInEvent(Long.parseLong(userId), Long.parseLong(eventId));
    }

    @GetMapping("/getPastWeekWinners")
    public List<WinnersOfPastWeek> getWinnersOfPastWeek() {
        return luckyDrawService.getWinnersOfPastWeek();
    }

    @GetMapping("/calculateWinner")
    public User calculateWinner(@RequestParam String eventId) {
        return luckyDrawService.calculateWinnerOfTheEvent(Long.parseLong(eventId));
    }


}

package com.grofers.luckydrawservice.DTO;

public class WinnersOfPastWeek {
    private String eventName;
    private String winnerName;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public WinnersOfPastWeek(String eventName, String winnerName) {
        this.eventName = eventName;
        this.winnerName = winnerName;
    }
}

package com.grofers.luckydrawservice.DTO;

import java.time.LocalDateTime;

public class NextEventTimingAndPrize {
    private LocalDateTime nextEventTiming;
    private String nextEventPrize;

    public LocalDateTime getNextEventTiming() {
        return nextEventTiming;
    }

    public void setNextEventTiming(LocalDateTime nextEventTiming) {
        this.nextEventTiming = nextEventTiming;
    }

    public String getNextEventPrize() {
        return nextEventPrize;
    }

    public void setNextEventPrize(String nextEventPrize) {
        this.nextEventPrize = nextEventPrize;
    }

    public NextEventTimingAndPrize(LocalDateTime nextEventTiming, String nextEventPrize) {
        this.nextEventTiming = nextEventTiming;
        this.nextEventPrize = nextEventPrize;
    }
}

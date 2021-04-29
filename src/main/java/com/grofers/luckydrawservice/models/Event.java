package com.grofers.luckydrawservice.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "event_id", nullable = false)
    private Long eventId;
    @Column(name = "event_name", nullable = false)
    private String eventName;
    @Column(name = "event_prize", nullable = false)
    private String eventPrize;
    @Column(name = "event_timing", nullable = false)
    private LocalDateTime eventTiming;
    @ElementCollection
    @Column(name = "participants")
    private List<Long> participants;
    @Column(name = "winnerId")
    private Long winnerId;


    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventPrize() {
        return eventPrize;
    }

    public void setEventPrize(String eventPrize) {
        this.eventPrize = eventPrize;
    }

    public LocalDateTime getEventTiming() {
        return eventTiming;
    }

    public void setEventTiming(LocalDateTime eventTiming) {
        this.eventTiming = eventTiming;
    }

    public List<Long> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Long> participants) {
        this.participants = participants;
    }

    public Long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }
}

package com.grofers.luckydrawservice.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "raffleTickets")
    private int raffleTickets;

    @ElementCollection
    @Column(name = "eventsParticipated")
    private List<Long> eventsParticipated;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRaffleTickets() {
        return raffleTickets;
    }

    public void setRaffleTickets(int raffleTickets) {
        this.raffleTickets = raffleTickets;
    }

    public List<Long> getEventsParticipated() {
        return eventsParticipated;
    }

    public void setEventsParticipated(List<Long> eventsParticipated) {
        this.eventsParticipated = eventsParticipated;
    }
}

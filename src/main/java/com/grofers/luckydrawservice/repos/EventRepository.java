package com.grofers.luckydrawservice.repos;

import com.grofers.luckydrawservice.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

    Event getEventByEventId(Long eventId);

}

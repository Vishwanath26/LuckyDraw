package com.grofers.luckydrawservice.repos;

import com.grofers.luckydrawservice.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    Event getEventByEventId(Long eventId);

    List<Event> findAllByEventTimingBetween(LocalDateTime oneWeekAgoDateTime, LocalDateTime now);

    Event findFirstEventByEventTimingAfter(LocalDateTime localDateTime);

}

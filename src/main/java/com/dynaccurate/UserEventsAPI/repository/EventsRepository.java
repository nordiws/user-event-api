package com.dynaccurate.UserEventsAPI.repository;

import java.util.List;

import com.dynaccurate.UserEventsAPI.models.Event;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EventsRepository extends MongoRepository<Event, String> {

    @Query("{'usernameId': ?0}")
    List<Event> findEventsByUserId(String userId);

    @Query("{'eventDateTime': {$gte: ?0, $lte: ?1}}")
    List<Event> findAllEventsByPeriod(String fromDate, String tillDate);

}

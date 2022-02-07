package com.dynaccurate.UserEventsAPI.services;

import java.util.List;

import com.dynaccurate.UserEventsAPI.models.Event;
import com.dynaccurate.UserEventsAPI.repository.EventsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventsServices {

    @Autowired
    EventsRepository eventsRepository;

    public List<Event> findAllEventsById(String userId) {
        List<Event> userEvents = eventsRepository.findEventsByUserId(userId);
        return userEvents;
    }

    public List<Event> findAllEventsByPeriod(String fromDate, String tillDate) {
        List<Event> allEvents = eventsRepository.findAllEventsByPeriod(fromDate, tillDate);
        return allEvents;
    }

}
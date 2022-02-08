package com.dynaccurate.UserEventsAPI.controller;

import java.util.List;

import com.dynaccurate.UserEventsAPI.models.Event;
import com.dynaccurate.UserEventsAPI.services.EventsServices;
import com.dynaccurate.UserEventsAPI.utilities.EventsUtilities;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventsServices eventsService;

    @Value("${rabbitmq.exchange}")
    String exchange;

    @Value("${rabbitmq.routing_key}")
    String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("")
    public List<Event> getEventsByPeriod(@RequestParam(required = false) String fromDate,
            @RequestParam(required = false) String tillDate) {
        List<Event> events = eventsService.findAllEventsByPeriod(fromDate, tillDate);
        return events;
    }

    @GetMapping("/{id}")
    public List<Event> getEventsByUserId(@PathVariable("id") String userId,
            @RequestParam(required = false) String sort) {

        List<Event> events = eventsService.findAllEventsById(userId);
        if (sort != null) {
            events = EventsUtilities.sortEvents(sort, events);
        }

        System.out.println("Retrieved all events by id : " + userId);
        return events;
    }

    @PostMapping("")
    public String sendEvent(@RequestBody Event event) {
        try {
            rabbitTemplate.convertAndSend(exchange, routingKey, event);

            System.out.println("Event sended: " + event.getEventType());
            return "Event posted successfully!";
        } catch (Exception e) {
            System.out.println(e);
            return "Error while sending event" + e;
        }
    }
}

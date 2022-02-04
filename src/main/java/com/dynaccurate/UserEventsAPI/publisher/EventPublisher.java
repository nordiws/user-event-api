package com.dynaccurate.UserEventsAPI.publisher;

import org.springframework.core.env.Environment;
import com.dynaccurate.UserEventsAPI.models.Event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Environment env;

    @PostMapping("")
    public String eventMessage(@RequestBody Event event) {
        rabbitTemplate.convertAndSend(env.getProperty("rabbitmq.exchange"), env.getProperty("rabbitmq.routing_key"),
                event);
        return "Event posted successfully!";
    }
}

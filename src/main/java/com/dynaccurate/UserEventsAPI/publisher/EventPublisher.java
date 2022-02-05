package com.dynaccurate.UserEventsAPI.publisher;

import com.dynaccurate.UserEventsAPI.models.Event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventPublisher {

    @Value("${rabbitmq.exchange}")
    String exchange;

    @Value("${rabbitmq.routing_key}")
    String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("")
    public String eventMessage(@RequestBody Event event) {
        rabbitTemplate.convertAndSend(exchange, routingKey, event);
        return "Event posted successfully!";
    }
}

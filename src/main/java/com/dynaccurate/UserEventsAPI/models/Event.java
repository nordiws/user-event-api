package com.dynaccurate.UserEventsAPI.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "events")
public class Event {
    @Id
    private String id;
    private String usernameId;
    private String eventType;
    private String eventDateTime;

    public Event() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.eventDateTime = localDateTime.format(formatter);
    }
}

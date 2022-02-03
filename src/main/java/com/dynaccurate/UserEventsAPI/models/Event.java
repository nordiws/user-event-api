package com.dynaccurate.UserEventsAPI.models;

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
    private String username;
    private String eventType;
    private String eventDateTime;
}

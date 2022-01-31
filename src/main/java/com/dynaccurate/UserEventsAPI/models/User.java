package com.dynaccurate.UserEventsAPI.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    @Getter
    @Setter
    private String username;
    @Getter
    private Date registrationDate;

    public User() {
        this.registrationDate = new Date();
    }
}

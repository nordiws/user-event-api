package com.dynaccurate.UserEventsAPI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping
    public ResponseEntity<?> getMainRoute() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "Welcome to User Event API");
        jsonObject.put("api-docs", "Access the /doc endpoint from a browser to read the API documentation");
        return ResponseEntity.ok(jsonObject);
    }

}

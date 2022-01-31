package com.dynaccurate.UserEventsAPI.controller;

import java.util.List;

import com.dynaccurate.UserEventsAPI.models.User;
import com.dynaccurate.UserEventsAPI.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "")
    public ResponseEntity<?> getUsers() {
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") String userId) {
        try {
            User user = userService.getUser(userId);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not Found", e);
        }
    }

    @PostMapping(path = "/save")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        user = userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") String userId, @RequestBody User user) {
        user = userService.updateUser(userId, user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String userId) {
        try {
            String result = userService.deleteUser(userId);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not Found", e);
        }

    }

}

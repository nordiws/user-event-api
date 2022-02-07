package com.dynaccurate.UserEventsAPI.services;

import java.util.List;
import java.util.Optional;

import com.dynaccurate.UserEventsAPI.models.User;
import com.dynaccurate.UserEventsAPI.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String userId, User user) {
        Optional<User> dbUser = userRepository.findById(userId);
        user.setId(dbUser.get().getId());
        return userRepository.save(user);
    }

    public String deleteUser(String userId) {
        userRepository.deleteById(userId);
        return userId;
    }
}

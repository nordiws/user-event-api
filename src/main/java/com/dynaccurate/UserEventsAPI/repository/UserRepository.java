package com.dynaccurate.UserEventsAPI.repository;

import com.dynaccurate.UserEventsAPI.models.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}

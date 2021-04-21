package com.example.Amazonclone.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository <User, String> {
    List<User> findByemail(String email);
}

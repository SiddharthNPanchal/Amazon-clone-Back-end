package com.example.Amazonclone.controller;

import com.example.Amazonclone.model.User;
import com.example.Amazonclone.model.UserRepository;
import com.example.Amazonclone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private UserRepository repo;

    @PostMapping(value = "/signup" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity adduser(@RequestBody User user){
        List<User> users = new ArrayList<>();
        for(User u: repo.findAll()){
            if(u.getEmail().equals(user.getEmail())){
                return  new ResponseEntity("Username already exists", HttpStatus.IM_USED);
            }
        }
        service.insertuser(user);
        return  new ResponseEntity(user, HttpStatus.OK);
    }
}

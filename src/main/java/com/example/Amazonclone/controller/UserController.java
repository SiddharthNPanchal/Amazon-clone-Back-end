package com.example.Amazonclone.controller;

import com.example.Amazonclone.customizedResponse;
import com.example.Amazonclone.model.User;
import com.example.Amazonclone.model.UserRepository;
import com.example.Amazonclone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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
        HashMap<String, String> map = new HashMap<>();
        map.put("foo", "bar");
        return  new ResponseEntity("user", HttpStatus.OK);
    }

    @PostMapping(value = "/login" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity login(@RequestBody User user){
//        List<User> users = new ArrayList<>();
//        for(User u: repo.findAll()){
//            if(!u.getEmail().equals(user.getEmail())){
//                return  new ResponseEntity("Username already exists", HttpStatus.IM_USED);
//            }
//        }
//        List<User> u = service.login(user);
//          service.login(user);
        var cust = new customizedResponse("Credentials", Collections.singletonList(service.login(user)));
        System.out.println(cust.getBody().get(0));
//      service.getCategories();
        if(cust.getBody().get(0)==null){
            System.out.println(cust.getBody());
            System.out.println("Null");
            return new ResponseEntity("Enter valid Credentials",HttpStatus.UNAUTHORIZED);

        }
        else {
            System.out.println(cust.getBody());
            System.out.println("Not null");
            return new ResponseEntity(cust, HttpStatus.OK);
        }
    }

}

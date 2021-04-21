package com.example.Amazonclone.controller;

import com.example.Amazonclone.customizedResponse;
import com.example.Amazonclone.model.Category;
import com.example.Amazonclone.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CatController {

    @Autowired
    private CategoryService service;

    @GetMapping("/categories")
    public ResponseEntity getCategories(){
        System.out.println("Hello");
        var cust = new customizedResponse("A list of all categories", service.getCategories());

        return new ResponseEntity(cust, HttpStatus.OK);
    }

    @PostMapping(value = "/categories" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity addCategory(@RequestBody Category cat){

        service.insertCategory(cat);
        return  new ResponseEntity(cat, HttpStatus.OK);
    }


}

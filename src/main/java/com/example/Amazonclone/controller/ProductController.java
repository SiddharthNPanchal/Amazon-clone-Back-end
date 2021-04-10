package com.example.Amazonclone.controller;

import com.example.Amazonclone.customizedResponse;
import com.example.Amazonclone.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Amazonclone.service.ProductService;

@RestController
public class ProductController {


    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity getProducts(){
        System.out.println("Hello");
        var cust = new customizedResponse("A list of all Products", service.getProducts());

        return new ResponseEntity(cust, HttpStatus.OK);
    }
    @PostMapping(value = "/products" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity addProduct(@RequestBody Product product){

        service.insertProducts(product);
        return  new ResponseEntity(product, HttpStatus.OK);
    }
}

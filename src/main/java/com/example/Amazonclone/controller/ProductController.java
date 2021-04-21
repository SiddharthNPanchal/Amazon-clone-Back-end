package com.example.Amazonclone.controller;

import com.example.Amazonclone.customizedResponse;
import com.example.Amazonclone.model.Product;
import com.example.Amazonclone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/product-category/{category}")
    public ResponseEntity getProductsfromCat(@PathVariable String category){
        var cust = new customizedResponse("A list of all Products by category", service.getProductsfromCat(category));
        return new ResponseEntity(cust, HttpStatus.OK);
    }

    @GetMapping("/products/bestsellers")
    public ResponseEntity getBestSellers(){
        var cust = new customizedResponse("A list of all Bestsellers", service.getBestSellers());

        return new ResponseEntity(cust, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProduct(@PathVariable String id){

        var cust = new customizedResponse("A list of all Products by category", Collections.singletonList(service.getProduct(id)));
//      service.getCategories();
        System.out.println(cust.getBody());
        if(cust.getBody().get(0)== Optional.empty()){
            return new ResponseEntity(cust, HttpStatus.OK);
        }
        else{
            System.out.println("Not found!");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity updateProduct(@PathVariable String id, @RequestBody Product p){
//        System.out.println("Hello");
        var cust = new customizedResponse("Updated Product", Collections.singletonList(service.updateProduct(id, p)));
//      service.getCategories();
        return new ResponseEntity(cust, HttpStatus.OK);

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteAProduct(@PathVariable String id)
    {
        service.deleteAProduct(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

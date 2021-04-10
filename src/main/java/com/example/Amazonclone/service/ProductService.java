package com.example.Amazonclone.service;

import com.example.Amazonclone.model.Product;
import com.example.Amazonclone.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getProducts(){
        return repo.findAll();
    }

    public void insertProducts(Product product){
        repo.insert(product);
    }

}

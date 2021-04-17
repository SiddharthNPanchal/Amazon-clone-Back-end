package com.example.Amazonclone.service;

import com.example.Amazonclone.model.Product;
import com.example.Amazonclone.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<String> getCategories(){
//        System.out.println(repo.findAll());
        Set<String> cat= new HashSet<>();
        for(Product p: repo.findAll()){

            cat.add(p.getCategory());
        }
        List<String> targetList = List.copyOf(cat);
        return targetList;
    }

    public List<Product> getProductsfromCat(String category){
//        List<Product> products = repo.findAll();
        List<Product> products = new ArrayList<>();
        for(Product p: repo.findAll()){
            if(p.getCategory().equals(category)){
                products.add(p);
            }
        }
        return products;
    }

    public List<Product> getBestSellers(){
//        List<Product> products = repo.findAll();
        List<Product> products = new ArrayList<>();
        for(Product p: repo.findAll()){
            if(p.isBestSeller()){
                products.add(p);
            }
        }
        return products;
    }

    public Optional<Product> getProduct(String id)
    {
        return repo.findById(id);
    }

    public Product updateProduct(String id, Product p){
        Optional<Product> ProductData = repo.findById(id);
        if (ProductData.isPresent()) {
            Product setData = ProductData.get();
            setData.setPrice(p.getPrice());
            setData.setQty(p.getQty());
            return repo.save(setData);
        }
        else{
            return null;
        }

    }

    public void deleteAProduct(String id)
    {
        repo.deleteById(id);
    }

}

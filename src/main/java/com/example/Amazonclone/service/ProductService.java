package com.example.Amazonclone.service;

import com.example.Amazonclone.model.Product;
import com.example.Amazonclone.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Product> getProductsfromCat(String category){
        List<Product> products = repo.findBycategory(category);
        return products;
    }

    public List<Product> getBestSellers(){

        List<Product> products = repo.findBybestSeller(true);
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

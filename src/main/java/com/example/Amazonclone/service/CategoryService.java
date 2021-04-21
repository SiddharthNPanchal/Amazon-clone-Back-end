package com.example.Amazonclone.service;

import com.example.Amazonclone.model.Category;
import com.example.Amazonclone.model.CategoryrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryrRepository repo;

    public List<Category> getCategories(){
        return repo.findAll();
    }
    public void insertCategory(Category cat){
        repo.insert(cat);
    }
}

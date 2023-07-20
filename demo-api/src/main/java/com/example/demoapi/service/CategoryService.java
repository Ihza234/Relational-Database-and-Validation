package com.example.demoapi.service;

import com.example.demoapi.model.entities.Category;
import com.example.demoapi.repository.CategoryRepo;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@TransactionScoped
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Category save (Category category){
        return categoryRepo.save(category);
    }
    public Category findOne(Long id){
        Optional<Category> category=categoryRepo.findById(id);
        if (!category.isPresent()){
        return null;
    }
    return category.get();
}
public Iterable<Category>findAll(){
        return categoryRepo.findAll();
}
public void removeOne(Long id){
        categoryRepo.deleteById(id);
}
}

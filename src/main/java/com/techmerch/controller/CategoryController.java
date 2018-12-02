package com.techmerch.controller;


import com.techmerch.model.Category;
import com.techmerch.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/api")
@CrossOrigin(origins = "*",allowedHeaders="*")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(path="/categories",method= RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}

package com.techmerch.controller;


import com.techmerch.model.SubCategory;
import com.techmerch.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController    // This means that this class is a Controller
@RequestMapping(path="/api")
@CrossOrigin(origins = "*",allowedHeaders="*")
public class SubCategoryController {
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @RequestMapping(path="/subcategories",method= RequestMethod.GET)
    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }
    @RequestMapping(path="/{categoryId}/subcategories",method= RequestMethod.GET)
    public List<SubCategory> getAllByCategory(@PathVariable(value = "categoryId")Long categoryId) {
        return subCategoryRepository.findAllByCategory(categoryId);
    }


}

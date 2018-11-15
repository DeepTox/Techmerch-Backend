package com.techmerch.techmerch;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/api-category")
@CrossOrigin(origins = "*",allowedHeaders="*")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(path="/categories",method= RequestMethod.GET)
    public @ResponseBody
    List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }
}

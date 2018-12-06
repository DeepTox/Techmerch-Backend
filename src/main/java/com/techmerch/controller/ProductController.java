package com.techmerch.controller;

import com.techmerch.model.Product;
import com.techmerch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/api")
@CrossOrigin(origins = "*",allowedHeaders="*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    // Add Product
    @RequestMapping(path="/addProduct",method = RequestMethod.POST)
    public String addProduct(@RequestBody Product product){
        productRepository.save(product);
        return product.getProductName() + " successfully added ";
    }
    // Get products
    @RequestMapping(path="/products",method= RequestMethod.GET)
    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }

    //Get products by category
    @RequestMapping(path="/products/{categoryId}",method= RequestMethod.GET)
    public List<Product> getAllProductsByCategory(@PathVariable (value = "categoryId") Long categoryId) {
        return  productRepository.findAllByCategory(categoryId);
    }
    //Get products by subcategory
    @RequestMapping(path="/scproducts/{subcategoryId}",method= RequestMethod.GET)
    public List<Product> getAllProductsBySubCategory(@PathVariable (value = "subcategoryId") Long subcategoryId) {
        return  productRepository.findAllBySubCategory(subcategoryId);
    }
    @RequestMapping(path="/product/{productId}",method = RequestMethod.GET)
    public Product getProductById(@PathVariable(value = "productId")Long productId){
        return productRepository.findById(productId).get();
    }
    //Delete product
    @RequestMapping(value = "/deleteProduct/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable (value = "productId") Long productId){
        productRepository.deleteById(productId);
    }
    //Update product
    @RequestMapping(value ="/updateProduct/{productId}", method = RequestMethod.POST)
    public  void updateProduct(@PathVariable (value = "productId") Long productId,@RequestBody Product product){
        product.setProductId(productId);
        productRepository.save(product);
    }
}

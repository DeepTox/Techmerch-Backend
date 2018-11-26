package com.techmerch.controller;

import com.techmerch.model.Product;
import com.techmerch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/api-product")
@CrossOrigin(origins = "*",allowedHeaders="*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(path="/add",method = RequestMethod.POST)
    public @ResponseBody String addProduct(@RequestBody Product product){

        productRepository.save(product);
        return product.getProductName() + " successfully added ";
    }
    @RequestMapping(path="/products",method= RequestMethod.GET)
    public @ResponseBody
    List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }
    @RequestMapping(path="/products/{categoryId}",method= RequestMethod.GET)
    public @ResponseBody
    List<Product> getAllProductsByCategory(@PathVariable (value = "categoryId") Long categoryId) {
        return (List<Product>) productRepository.findAllByCategory(categoryId);
    }
    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable (value = "productId") Long productId){
        productRepository.deleteById(productId);
    }
    @RequestMapping(value ="/update/{productId}", method = RequestMethod.POST)
    public  void updateProduct(@PathVariable (value = "productId") Long productId,@RequestBody Product product){
        product.setProductId(productId);
        productRepository.save(product);
    }
}

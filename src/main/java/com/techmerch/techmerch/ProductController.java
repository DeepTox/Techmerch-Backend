package com.techmerch.techmerch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/api")
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

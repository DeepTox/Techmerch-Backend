package com.techmerch.techmerch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @RequestMapping(value="/{productId}", method = RequestMethod.POST)
    public void saveItem(@RequestParam (value = "q") String quantity,
                         @PathVariable (value = "productId") Long productId){
        int q = Integer.parseInt(quantity);
        Product product=productRepository.findById(productId).get();
        CartItem cartItem = new CartItem();
        Cart cart = cartRepository.findById(1L).get();
        cartItem.setProduct(product);
        cartItem.setQuantity(q);
        cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemRepository.save(cartItem);
        System.out.println("success");

    }
    @RequestMapping(value = "/{cartItemId}", method = RequestMethod.DELETE)
    public void removeItem(@PathVariable (value = "cartItemId") Long cartItemId){
        cartItemRepository.deleteById(cartItemId);
    }
}

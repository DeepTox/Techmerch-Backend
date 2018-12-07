package com.techmerch.controller;


import com.techmerch.model.Order;
import com.techmerch.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
@CrossOrigin(origins = "*",allowedHeaders="*")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(path="/orders/{clientId}", method = RequestMethod.GET)
    public List<Order>  getOrdersByClientId(@PathVariable(value = "clientId")String clientId){
        return orderRepository.findAllByClientId(clientId);
    }
    @RequestMapping(path="/orders", method = RequestMethod.GET)
    public List<Order>  getAll(){
        return orderRepository.findAll();
    }
    @RequestMapping(path="/orders/add", method = RequestMethod.POST)
    public void addOrder(@RequestBody Order order){
        orderRepository.save(order);
    }
    @RequestMapping(path="/orders/update", method = RequestMethod.PUT)
    public void updateOrder(@RequestBody Order order){
        orderRepository.save(order);
    }
    @RequestMapping(path="/orders/delete/{orderId}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable(value = "orderId")Long orderId){
        orderRepository.deleteById(orderId);
    }

}

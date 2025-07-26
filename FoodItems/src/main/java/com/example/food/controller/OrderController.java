package com.example.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.food.model.Order;
import com.example.food.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //Place a new Order
    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        orderService.placeOrder(order);
        return "Order placed successfully";
    }

    //Get all Orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    //  Get Order by ID
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    // Update Order Status
    @PutMapping("/{id}/status")
    public String updateOrderStatus(@PathVariable String id, @RequestParam String status) {
        orderService.updateOrderStatus(id, status);
        return "Order status updated to " + status;
    }

    // Delete Order
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return "Order deleted successfully";
    }
}

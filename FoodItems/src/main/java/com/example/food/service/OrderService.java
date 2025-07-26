package com.example.food.service;

import java.util.List;

import com.example.food.model.Order;

public interface OrderService {

	Order placeOrder(Order order);
	List<Order> getAllOrders();
	Order getOrderById(String id);
	Order updateOrderStatus(String id,String status);
	void deleteOrder(String id);
}

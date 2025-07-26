package com.example.food.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.food.model.Order;

public interface OrderRepository extends MongoRepository<Order,String> {

}

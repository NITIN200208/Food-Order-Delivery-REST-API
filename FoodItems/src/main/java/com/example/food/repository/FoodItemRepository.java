package com.example.food.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.food.model.FoodItem;

public interface FoodItemRepository extends MongoRepository<FoodItem,String>{

}

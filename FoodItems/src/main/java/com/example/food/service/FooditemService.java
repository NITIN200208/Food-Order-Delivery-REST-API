package com.example.food.service;

import java.util.List;

import com.example.food.model.FoodItem;

public interface FooditemService {

	FoodItem addFoodItem(FoodItem foodItem);
	List<FoodItem> getAllFood();
	FoodItem getFoodItemId(String id);
	FoodItem updateFoodItem(String id, FoodItem foodItem);
	void deleteFoodItem(String id);
	
	
	
}

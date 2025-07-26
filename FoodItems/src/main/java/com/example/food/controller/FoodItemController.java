
	
	package com.example.food.controller;

	import java.util.Date;
import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import com.example.food.model.FoodItem;
	import com.example.food.responseApi.ApiResponse;
	import com.example.food.service.FooditemService;


	@RestController
	@RequestMapping("/api/food")
	public class FoodItemController {

	    @Autowired
	    private FooditemService foodItemService;

	    //Create a new Food Item
	    @PostMapping
	    public ApiResponse<FoodItem> create(@RequestBody FoodItem foodItem) {
	    	foodItem.setCreatedAt(new Date()); 
	        FoodItem saved = foodItemService.addFoodItem(foodItem);
	        return new ApiResponse<>("Food item created successfully", saved);
	    }

	    //  Get all Food Items
	    @GetMapping
	    public ApiResponse<List<FoodItem>> getAllFoodList() {
	        List<FoodItem> list = foodItemService.getAllFood();
	        return new ApiResponse<>("All food items fetched successfully", list);
	    }

	    //  Get Food Item by ID
	    @GetMapping("/{id}")
	    public ApiResponse<FoodItem> getFoodById(@PathVariable String id) {
	        FoodItem foodItem = foodItemService.getFoodItemId(id);
	        return new ApiResponse<>("Food item fetched successfully", foodItem);
	    }

	    // Update Food Item
	    @PutMapping("/{id}")
	    public ApiResponse<FoodItem> updateFood(@PathVariable String id, @RequestBody FoodItem foodItem) {
	        FoodItem updated = foodItemService.updateFoodItem(id, foodItem);
	        return new ApiResponse<>("Food item updated successfully", updated);
	    }

	    // Delete Food Item
	    @DeleteMapping("/{id}")
	    public ApiResponse<String> deleteFood(@PathVariable String id) {
	        foodItemService.deleteFoodItem(id);
	        return new ApiResponse<>("Food item deleted successfully", id);
	    }
	}


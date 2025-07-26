package com.example.food.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.food.model.FoodItem;
import com.example.food.repository.FoodItemRepository;
import com.example.food.service.FooditemService;


@Service
public class FoodItemServiceImp implements FooditemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

	@Override
	public FoodItem addFoodItem(FoodItem foodItem) {
		// TODO Auto-generated method stub
		return foodItemRepository.save(foodItem);

	}

	@Override
	public List<FoodItem> getAllFood() {
		// TODO Auto-generated method stub
		return foodItemRepository.findAll();
	}

	@Override
	public FoodItem getFoodItemId(String id) {
		// TODO Auto-generated method stub\
	    return foodItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food item not found: " + id));
		 
	}

	@Override
	public FoodItem updateFoodItem(String id, FoodItem foodItem) {
		// TODO Auto-generated method stub
		FoodItem existing = getFoodItemId(id);
        existing.setName(foodItem.getName());
        existing.setDescription(foodItem.getDescription());
        existing.setPrice(foodItem.getPrice());
        existing.setCategory(foodItem.getCategory());
        existing.setAvailability(foodItem.isAvailability());
        return foodItemRepository.save(existing);
	}

	@Override
	public void deleteFoodItem(String id) {
		// TODO Auto-generated method stub
		foodItemRepository.deleteById(id);
		
	}

}


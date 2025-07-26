package com.example.food.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "foodItems")
public class FoodItem {

    @Id
    private String id;

    private String name;
    private String description;
    private double price;
    private String category;
    private boolean availability;

    @CreatedDate
    private Date createdAt;
}

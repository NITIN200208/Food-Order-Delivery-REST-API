package com.example.food.model;



import lombok.Data;

@Data
public class OrderItem {
    private String foodItemId;
    private String foodItemName;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
}

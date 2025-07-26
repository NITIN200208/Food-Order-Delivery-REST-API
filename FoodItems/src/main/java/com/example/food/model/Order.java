package com.example.food.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private String customerName;
    private String deliveryAddress;

    private List<OrderItem> items;

    private double orderTotal;

    private OrderStatus status = OrderStatus.PENDING; // default

    @CreatedDate
    private LocalDateTime orderedAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}

package com.example.food.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.food.model.FoodItem;
import com.example.food.model.Order;
import com.example.food.model.OrderItem;
import com.example.food.model.OrderStatus;
import com.example.food.repository.FoodItemRepository;
import com.example.food.repository.OrderRepository;
import com.example.food.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Override
    public Order placeOrder(Order order) {
        double total = 0.0;

        for (OrderItem item : order.getItems()) {
            FoodItem food = foodItemRepository.findById(item.getFoodItemId())
                    .orElseThrow(() -> new RuntimeException("Food item not found: " + item.getFoodItemId()));

            item.setFoodItemName(food.getName());
            item.setUnitPrice(food.getPrice());
            item.setTotalPrice(food.getPrice() * item.getQuantity());
            total += item.getTotalPrice();  //
        }

        order.setOrderTotal(total);
        order.setStatus(OrderStatus.PENDING);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(String id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }

    @Override
    public Order updateOrderStatus(String id, String status) {
        Order existingOrder = getOrderById(id);

        try {
            OrderStatus newStatus = OrderStatus.valueOf(status.toUpperCase());
            existingOrder.setStatus(newStatus);
            return orderRepository.save(existingOrder);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid status: " + status + ". Allowed: PENDING, ACCEPTED, DISPATCHED, DELIVERED, CANCELLED");
        }
    }

    @Override
    public void deleteOrder(String id) {
        Order order = getOrderById(id);
        if (order.getStatus() == OrderStatus.DELIVERED) {
            throw new RuntimeException("Cannot delete a delivered order");
        }
        orderRepository.deleteById(id);
    }
}

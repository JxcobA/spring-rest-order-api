package com.example.spring.web.services;

import com.example.spring.web.entities.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrderById(Long id);
    List<Order> getAllOrders();

}

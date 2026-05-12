package com.example.spring.web.services;

import com.example.spring.web.entities.Order;
import com.example.spring.web.exceptions.DuplicateOrderEmailException;
import com.example.spring.web.exceptions.OrderNotFoundException;
import com.example.spring.web.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        if (orderRepository.existsByEmail(order.getEmail())) {
            throw new DuplicateOrderEmailException(
                    "Order already exists for email: " + order.getEmail()
            );
        }
        return orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException("Order not found with id: " + id)
                );
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}

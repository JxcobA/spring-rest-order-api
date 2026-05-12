package com.example.spring.web.repositories;

import com.example.spring.web.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByEmail(String email);
    boolean existsByEmail(String email);

}

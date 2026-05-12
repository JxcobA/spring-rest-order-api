package com.example.spring.web.apis;
import com.example.spring.web.apis.dto.OrderRequestDTO;
import com.example.spring.web.entities.Order;
import com.example.spring.web.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDTO request) {
        /*Order order = new Order(
                request.totalQuantity(),
                request.totalPrice(),
                request.status(),
                request.email()
        );*/
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderService.createOrder(null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}

package com.example.spring.web.apis.dto;

import java.math.BigDecimal;

public record OrderRequestDTO(
        int totalQuantity,
        BigDecimal totalPrice,
        boolean status,
        String email
) {}

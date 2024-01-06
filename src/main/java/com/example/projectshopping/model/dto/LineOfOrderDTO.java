package com.example.projectshopping.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LineOfOrderDTO {

    private Long id;
    private Long productId;
    private int quantity;
    private BigDecimal unitPrice;

    // Gettery, Settery, Konstruktory
}
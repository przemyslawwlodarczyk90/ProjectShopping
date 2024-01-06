package com.example.projectshopping.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Data
public class OrderDTO {

    private Long id;
    private Long userId;
    private String orderStatus;
    private LocalDate dateCreated;
    private LocalDate sentAt;
    private BigDecimal totalPrice;
    private List<LineOfOrderDTO> lineOfOrders; // Zakładam, że istnieje odpowiednie DTO dla LineOfOrder

    // Gettery, Settery, Konstruktory
}
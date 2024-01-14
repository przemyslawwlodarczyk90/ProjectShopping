package com.example.projectshopping.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Builder
public record LineOfOrderDTO(
        Long id,
        Long productId,
        int quantity,
        BigDecimal unitPrice
) {

    public LineOfOrderDTO {
        Objects.requireNonNull(id);
        Objects.requireNonNull(productId);
        Objects.requireNonNull(quantity);
        Objects.requireNonNull(unitPrice);
    }
}
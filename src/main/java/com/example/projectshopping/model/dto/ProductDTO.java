package com.example.projectshopping.model.dto;

import com.example.projectshopping.model.enums.ProductType;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Builder

public record ProductDTO(
        Long id,
        Long authorId,
        Long categoryId,
        String title,
        String description,
        String miniature,
        BigDecimal price,
        ProductType productType
) {

    public ProductDTO {
        Objects.requireNonNull(id);
        Objects.requireNonNull(title);
        Objects.requireNonNull(description);
        Objects.requireNonNull(miniature);
        Objects.requireNonNull(price);
        Objects.requireNonNull(productType);
    }
}
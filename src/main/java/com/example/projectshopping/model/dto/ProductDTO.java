package com.example.projectshopping.model.dto;

import com.example.projectshopping.model.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private ProductType productType;
    // Getters and setters
}
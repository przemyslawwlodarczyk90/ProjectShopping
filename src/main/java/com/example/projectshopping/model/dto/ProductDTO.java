package com.example.projectshopping.model.dto;

import com.example.projectshopping.model.enums.ProductType;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Data
@Builder
public class ProductDTO {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private ProductType productType;

    private AuthorDTO authorDTO;
    // Getters and setters
}
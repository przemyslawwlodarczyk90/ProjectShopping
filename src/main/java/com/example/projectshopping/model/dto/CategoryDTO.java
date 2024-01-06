package com.example.projectshopping.model.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private Long parentCategoryId;
}
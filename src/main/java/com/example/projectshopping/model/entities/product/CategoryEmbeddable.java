package com.example.projectshopping.model.entities.product;

import lombok.Data;

public class CategoryEmbeddable {

    private Category category;
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
package com.example.projectshopping.model.entities.product;

import lombok.Data;

public class CategoryEmbeddable {

    private Category category;
    private Long id;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
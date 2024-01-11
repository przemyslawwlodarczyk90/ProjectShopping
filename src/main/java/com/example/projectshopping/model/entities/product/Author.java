package com.example.projectshopping.model.entities.product;

import lombok.Data;

public class Author {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
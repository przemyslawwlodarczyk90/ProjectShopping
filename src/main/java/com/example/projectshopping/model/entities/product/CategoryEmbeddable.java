package com.example.projectshopping.model.entities.product;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class CategoryEmbeddable {

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
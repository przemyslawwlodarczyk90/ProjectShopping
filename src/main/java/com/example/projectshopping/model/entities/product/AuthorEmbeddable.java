package com.example.projectshopping.model.entities.product;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class AuthorEmbeddable {

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
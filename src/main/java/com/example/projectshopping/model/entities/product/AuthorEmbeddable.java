package com.example.projectshopping.model.entities.product;

import lombok.Data;

public class AuthorEmbeddable {

    private Author author;
    private Long id;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
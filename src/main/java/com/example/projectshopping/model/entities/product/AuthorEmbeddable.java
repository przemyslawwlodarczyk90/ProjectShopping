package com.example.projectshopping.model.entities.product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class AuthorEmbeddable {
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
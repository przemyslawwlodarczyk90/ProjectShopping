package com.example.projectshopping.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}
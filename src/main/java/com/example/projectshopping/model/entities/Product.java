package com.example.projectshopping.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import pl.sda.ShopAppProject.model.enitiies.Author;
import pl.sda.ShopAppProject.model.enitiies.Category;
import pl.sda.ShopAppProject.model.enums.ProductType;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private String miniature;

    private Category category;

    private Float cena;

    @Enumerated(EnumType.STRING)
    private ProductType productType;


    private Author author;
}
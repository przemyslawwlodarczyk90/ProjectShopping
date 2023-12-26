package com.example.projectshopping.model.entities;

import com.example.projectshopping.model.entities.Author;
import com.example.projectshopping.model.entities.Category;
import com.example.projectshopping.model.enums.ProductType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table (name = "products")
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

 @ManyToOne(fetch = FetchType.LAZY)
 private Category category;

 @ManyToMany(fetch = FetchType.LAZY)
 private List<Author> authors;

 private BigDecimal price;

 @Enumerated(EnumType.STRING)
 private ProductType productType;

// private int quantity; // added

 public Product() {}

 public Product(Long id, String title, String description, String miniature, Category category, BigDecimal price,
                ProductType productType) {
  this.id = id;
  this.title = title;
  this.description = description;
  this.miniature = miniature;
  this.category = category;
  this.price = price;
  this.productType = productType;

 }


 public List<Author> getAuthors() {
  return authors;
 }

 public void setAuthors(List<Author> authors) {
  this.authors = authors;
 }
}
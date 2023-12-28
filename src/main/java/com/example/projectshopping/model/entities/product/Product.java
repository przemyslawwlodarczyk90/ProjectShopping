package com.example.projectshopping.model.entities.product;


import com.example.projectshopping.model.enums.ProductType;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(name = "title")
 private String title;

 @Column(name = "description")
 private String description;

 @Column(name = "miniature")
 private String miniature;

 private AuthorEmbeddable author;

 private CategoryEmbeddable category;

 @Column(name = "price")
 private BigDecimal price;

 @Enumerated(EnumType.STRING)
 private ProductType productType;

 @Column(name = "quantity")
 private int quantity;

 @Column(name = "created_at")
 @Temporal(TemporalType.TIMESTAMP)
 private Date createdAt;

 @Column(name = "updated_at")
 @Temporal(TemporalType.TIMESTAMP)
 private Date updatedAt;

 public Product(String title, String description, String miniature, AuthorEmbeddable author, CategoryEmbeddable category,
                BigDecimal price, ProductType productType, int quantity) {
  this.title = title;
  this.description = description;
  this.miniature = miniature;
  this.author = author;
  this.category = category;
  this.price = price;
  this.productType = productType;
  this.quantity = quantity;
 }
}
package com.example.projectshopping.model.entities.product;


import com.example.projectshopping.model.enums.ProductType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


public class Product {

 private Long id;

 private AuthorEmbeddable author;

 private CategoryEmbeddable category;

 private String title;

 private String description;

 private String miniature;

 private BigDecimal price;

 private ProductType productType;


 public Product() {
 }

 public Product(String title, String description, String miniature, AuthorEmbeddable author, CategoryEmbeddable category, BigDecimal price, ProductType productType) {
  this.title = title;
  this.description = description;
  this.miniature = miniature;
  this.author = author;
  this.category = category;
  this.price = price;
  this.productType = productType;
 }

 public BigDecimal getPrice() {
  return price;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public AuthorEmbeddable getAuthor() {
  return author;
 }

 public void setAuthor(AuthorEmbeddable author) {
  this.author = author;
 }

 public CategoryEmbeddable getCategory() {
  return category;
 }

 public void setCategory(CategoryEmbeddable category) {
  this.category = category;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 public String getMiniature() {
  return miniature;
 }

 public void setMiniature(String miniature) {
  this.miniature = miniature;
 }

 public void setPrice(BigDecimal price) {
  this.price = price;
 }

 public ProductType getProductType() {
  return productType;
 }

 public void setProductType(ProductType productType) {
  this.productType = productType;
 }


}
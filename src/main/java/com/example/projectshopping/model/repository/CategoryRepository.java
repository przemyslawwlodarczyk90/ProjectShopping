package com.example.projectshopping.model.repository;

import com.example.projectshopping.model.entities.product.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {


    List<Category> findByNameContainingIgnoreCase(String name);


    List<Category> findByParentCategory(Category parentCategory);


    Category save(Category category);

    List<Category> findAll();

    Optional<Category> findById(Long id);
}



package com.example.projectshopping.model.repository;

import com.example.projectshopping.model.entities.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    List<Category> findByNameContainingIgnoreCase(String name);


    List<Category> findByParentCategory(Category parentCategory);




}



package com.example.projectshopping.service;

import com.example.projectshopping.model.entities.product.Category;
import com.example.projectshopping.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {


    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();

    }



    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        Category category = getCategoryById(id);
        if (category != null) {
            category.setName(updatedCategory.getName());
            category.setParentCategory(updatedCategory.getParentCategory());
            return categoryRepository.save(category);
        }
        return null;
    }

}

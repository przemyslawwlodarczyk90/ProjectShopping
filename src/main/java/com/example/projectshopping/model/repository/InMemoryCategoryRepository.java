package com.example.projectshopping.model.repository;

import com.example.projectshopping.model.entities.product.Category;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
class InMemoryCategoryRepository implements CategoryRepository {

  private Map<Long, Category> categories = new HashMap<>();
  private Long currentId = 1L;

  @Override
  public Category save(Category category) {
    if (category.getId() == null) {
      category.setId(currentId++);
    }
    categories.put(category.getId(), category);
    return category;
  }

  @Override
  public List<Category> findAll() {
    return new ArrayList<>(categories.values());
  }

  @Override
  public Optional<Category> findById(Long id) {
    return Optional.ofNullable(categories.get(id));
  }

  // Dodatkowe metody, jeśli są wymagane
}
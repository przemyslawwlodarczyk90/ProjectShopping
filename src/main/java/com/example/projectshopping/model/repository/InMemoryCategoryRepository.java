package com.example.projectshopping.model.repository;

import com.example.projectshopping.model.entities.product.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
class InMemoryCategoryRepository implements CategoryRepository {

  @Override
  public List<Category> findByNameContainingIgnoreCase(String name) {
    return null;
  }

  @Override
  public List<Category> findByParentCategory(Category parentCategory) {
    return null;
  }

  @Override
  public Category save(Category category) {
    return null;
  }

  @Override
  public List<Category> findAll() {
    return null;
  }

  @Override
  public Optional<Category> findById(Long id) {
    return Optional.empty();
  }
}

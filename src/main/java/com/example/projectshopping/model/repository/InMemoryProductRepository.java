package com.example.projectshopping.model.repository;

import com.example.projectshopping.model.entities.product.Category;
import com.example.projectshopping.model.entities.product.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
class InMemoryProductRepository implements ProductRepository {

  @Override
  public List<Product> findAll() {
    return null;
  }

  @Override
  public List<Product> findAllByCategory(Category category) {
    return null;
  }

  @Override
  public List<Product> findAllByPrice(int minPrice, int maxPrice) {
    return null;
  }

  @Override
  public List<Product> findAllByPriceOrderByPrice(int minPrice, int maxPrice, boolean ascending) {
    return null;
  }

  @Override
  public List<Product> findAllByTitleContainingIgnoreCase(String title) {
    return null;
  }

  @Override
  public List<Product> findAllByAuthor(String author) {
    return null;
  }

  @Override
  public Optional<Product> findById(long id) {
    return Optional.empty();
  }

  @Override
  public Product save(Product product) {
    return null;
  }

  @Override
  public void delete(Product product) {

  }
}

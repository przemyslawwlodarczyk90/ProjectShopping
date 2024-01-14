package com.example.projectshopping.model.repository;

import com.example.projectshopping.model.entities.product.Category;
import com.example.projectshopping.model.entities.product.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
class InMemoryProductRepository implements ProductRepository {

  private final Map<Long, Product> products = new HashMap<>();
  private Long currentId = 1L;

  @Override
  public List<Product> findAll() {
    return new ArrayList<>(products.values());
  }



  // Inne metody, takie jak findAllByPrice, findAllByTitleContainingIgnoreCase itd.

  @Override
  public Optional<Product> findById(long id) {
    return Optional.ofNullable(products.get(id));
  }

  @Override
  public Product save(Product product) {
    if (product.getId() == null) {
      product.setId(currentId++);
    }
    products.put(product.getId(), product);
    return product;
  }

  @Override
  public void delete(Product product) {
    products.remove(product.getId());
  }
}
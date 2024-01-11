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

  @Override
  public List<Product> findAllByCategory(Category category) {
    return products.values().stream()
            .filter(product -> product.getCategory().getCategory().equals(category))
            .collect(Collectors.toList());
  }

  @Override
  public List<Product> findAllByPrice(int minPrice, int maxPrice) {
    BigDecimal min = BigDecimal.valueOf(minPrice);
    BigDecimal max = BigDecimal.valueOf(maxPrice);
    return products.values().stream()
            .filter(product -> product.getPrice().compareTo(min) >= 0 &&
                    product.getPrice().compareTo(max) <= 0)
            .collect(Collectors.toList());
  }

  @Override
  public List<Product> findAllByPriceOrderByPrice(int minPrice, int maxPrice, boolean ascending) {
    BigDecimal min = BigDecimal.valueOf(minPrice);
    BigDecimal max = BigDecimal.valueOf(maxPrice);
    Stream<Product> filteredProducts = products.values().stream()
            .filter(product -> product.getPrice().compareTo(min) >= 0 &&
                    product.getPrice().compareTo(max) <= 0);

    if (ascending) {
      return filteredProducts.sorted(Comparator.comparing(Product::getPrice))
              .collect(Collectors.toList());
    } else {
      return filteredProducts.sorted(Comparator.comparing(Product::getPrice).reversed())
              .collect(Collectors.toList());
    }
  }

  @Override
  public List<Product> findAllByTitleContainingIgnoreCase(String title) {
    return products.values().stream()
            .filter(product -> product.getTitle().toLowerCase().contains(title.toLowerCase()))
            .collect(Collectors.toList());
  }

  @Override
  public List<Product> findAllByAuthor(String author) {
    return products.values().stream()
            .filter(product -> product.getAuthor().getAuthor().getName().equalsIgnoreCase(author))
            .collect(Collectors.toList());
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
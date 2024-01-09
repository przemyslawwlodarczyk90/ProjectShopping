package com.example.projectshopping.model.repository;


import com.example.projectshopping.model.entities.product.Category;
import com.example.projectshopping.model.entities.product.Product;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    List<Product> findAll();

    List<Product> findAllByCategory(Category category);

    List<Product> findAllByPrice(int minPrice, int maxPrice);

    List<Product> findAllByPriceOrderByPrice(int minPrice, int maxPrice, boolean ascending);

    List<Product> findAllByTitleContainingIgnoreCase(String title);

    List<Product> findAllByAuthor(String author);

    Optional<Product> findById(long id);

    Product save(Product product);;

    void delete(Product product);
}

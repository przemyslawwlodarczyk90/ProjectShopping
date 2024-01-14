package com.example.projectshopping.model.repository;


import com.example.projectshopping.model.entities.product.Category;
import com.example.projectshopping.model.entities.product.Product;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    List<Product> findAll();


    Optional<Product> findById(long id);

    Product save(Product product);;

    void delete(Product product);

    void deleteById(long id); // Dodana metoda
}

package com.example.projectshopping.service;

import com.example.projectshopping.model.entities.product.Category;
import com.example.projectshopping.model.entities.product.Product;
import com.example.projectshopping.model.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
    public List<Product> findAllProductsByCategory(Category category) {
        return productRepository.findAllByCategory(category);
    }

    public List<Product> findAllProductsByPrice(int minPrice, int maxPrice) {
        return productRepository.findAllByPrice(minPrice, maxPrice);
    }

    public List<Product> findAllProductsByPriceOrderByPrice(int minPrice, int maxPrice, boolean ascending) {
        return productRepository.findAllByPriceOrderByPrice(minPrice, maxPrice, ascending);
    }

    public List<Product> findAllProductsByTitleContainingIgnoreCase(String title) {
        return productRepository.findAllByTitleContainingIgnoreCase(title);
    }

    public List<Product> findAllProductsByAuthor(String author) {
        return productRepository.findAllByAuthor(author);
    }

    public Product findProductById(long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
package com.example.projectshopping.service;

import com.example.projectshopping.model.dto.ProductDTO;
import com.example.projectshopping.model.entities.product.Category;
import com.example.projectshopping.model.entities.product.Product;
import com.example.projectshopping.model.repository.ProductRepository;
import com.example.projectshopping.util.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private  ProductRepository productRepository;
    private ObjectMapperUtils mapper;

    public ProductService(ProductRepository productRepository, ObjectMapperUtils mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public List<ProductDTO> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                        .productType(product.getProductType())
                        .description()
                        .price()
                        .authorDto()

                        .build())
                .collect(Collectors.toList());
//        return mapper.mapAll(productRepository.findAll(), ProductDTO.class);
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
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
        return productRepository.findById(id).get();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
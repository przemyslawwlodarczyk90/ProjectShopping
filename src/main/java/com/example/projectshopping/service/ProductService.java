package com.example.projectshopping.service;

import com.example.projectshopping.model.dto.ProductDTO;
import com.example.projectshopping.model.entities.product.*;
import com.example.projectshopping.model.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> findAllProductDTOs() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findProductDTOById(Long id) {
        return productRepository.findById(id)
                .map(this::convertToProductDTO)
                .orElse(null);
    }

    public ProductDTO saveProductDTO(ProductDTO productDTO) {
        Product product = convertToProduct(productDTO);
        Product savedProduct = productRepository.save(product);
        return convertToProductDTO(savedProduct);
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private ProductDTO convertToProductDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .miniature(product.getMiniature())
                .price(product.getPrice())
                .productType(product.getProductType())
                .authorId(product.getAuthor() != null ? product.getAuthor().getId() : null)
                .categoryId(product.getCategory() != null ? product.getCategory().getId() : null)
                .build();
    }

    private Product convertToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setMiniature(productDTO.getMiniature());
        product.setPrice(productDTO.getPrice());
        product.setProductType(productDTO.getProductType());

        AuthorEmbeddable author = new AuthorEmbeddable();
        author.setId(productDTO.getAuthorId());

        product.setAuthor(author);


        CategoryEmbeddable category = new CategoryEmbeddable();
        category.setId(productDTO.getCategoryId());
        product.setCategory(category);

        return product;
}}
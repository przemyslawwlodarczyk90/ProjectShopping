package com.example.projectshopping;

import com.example.projectshopping.model.entities.product.*;
import com.example.projectshopping.model.enums.ProductType;
import org.springframework.boot.SpringApplication;
import org .springframework.boot.autoconfigure.SpringBootApplication;
import java.math.BigDecimal;

@SpringBootApplication
public class ProjectShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectShoppingApplication.class, args);

        // Create a category
        Category category1 = new Category(1L,"Książki");

        // Create an author
        Author author1 = new Author();

        // Create an author embeddable
        AuthorEmbeddable authorEmbeddable1 = new AuthorEmbeddable();

        // Create a category embeddable
        CategoryEmbeddable categoryEmbeddable1 = new CategoryEmbeddable();

        // Create a product with all mandatory parameters
        Product product1 = new Product(
        );

        // Create another product with all mandatory parameters
        Product product2 = new Product(
        );

        // Create a third product with all mandatory parameters
        Product product3 = new Product(
        );
    }
}
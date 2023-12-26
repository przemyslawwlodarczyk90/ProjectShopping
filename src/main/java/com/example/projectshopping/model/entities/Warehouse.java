package com.example.projectshopping.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    @OneToMany(mappedBy = "warehouse")
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void deductProduct(Product product, int quantity) {
        if (this.products.get(product).getQuantity() < quantity) {
            throw new RuntimeException("Product " + product.getName() + " is not available in sufficient quantity.");
        }

        this.products.get(product).setQuantity(this.products.get(product).getQuantity() - quantity);
    }
}
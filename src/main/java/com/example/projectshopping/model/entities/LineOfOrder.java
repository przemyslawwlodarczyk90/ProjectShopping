package com.example.projectshopping.model.entities;

import com.example.projectshopping.model.entities.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Data
public class LineOfOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public BigDecimal calculateTotalPrice() {
        return this.unitPrice.multiply(BigDecimal.valueOf(this.quantity));
    }
}
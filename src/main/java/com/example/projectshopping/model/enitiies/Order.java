package com.example.projectshopping.model.enitiies;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import pl.sda.ShopAppProject.model.enitiies.Address;
import pl.sda.ShopAppProject.model.enitiies.Customer;
import pl.sda.ShopAppProject.model.entities.Product;
import pl.sda.ShopAppProject.model.enums.OrderStatus;

import java.time.LocalDate;
import java.util.List;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;

    private Float totalCost;

    @Embedded
    private Address shippingAddress;

    @Embedded
    private Address userAddress;

    @NotNull
    private LocalDate placedDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Product> orderItems;

    @ManyToOne
    @NotNull
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void calculateTotalCost() {
        totalCost = 0f;
        for (OrderItem orderItem : orderItems) {
            totalCost += orderItem.getProduct().getPrice() * orderItem.getQuantity();
        }
    }
}
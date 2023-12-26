package com.example.projectshopping.model.entities;

import com.example.projectshopping.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Component
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @Column(name = "user_address")
    private UserAddress userAddress;

    @Column(name = "shipping_address")
    private ShippingAddress shippingAddress;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineOfOrder> orderItems = new ArrayList<>();

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @Column(name = "date_of_order")
    private Date dateOfOrder;

    @Column(name = "shipping_date")
    private Date shippingDate;

    @Column(name = "order_status")
    private OrderStatus orderStatus;


    public List<LineOfOrder> getOrderLines() {
        return orderItems;
    }

    public BigDecimal calculateTotalCost() {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (LineOfOrder orderItem : this.orderItems) {
            totalCost = totalCost.add(orderItem.getProduct().getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
        }
        return totalCost;
    }



}
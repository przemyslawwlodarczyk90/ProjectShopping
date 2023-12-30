package com.example.projectshopping.model.entities.order;

import com.example.projectshopping.model.entities.product.Product;
import com.example.projectshopping.model.entities.user.User;
import com.example.projectshopping.model.enums.OrderStatus;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private User customer;

    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;

    @Column(name = "date_created")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCreated;

    @Column(name = "sent_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate sentAt;



    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<LineOfOrder> lineOfOrders;

    private BigDecimal totalPrice;

    public void calculateTotalPrice(List<LineOfOrder> lineOfOrders) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (LineOfOrder lineOfOrder : lineOfOrders) {
            totalPrice = totalPrice.add(lineOfOrder.getUnitPrice().multiply(new BigDecimal(lineOfOrder.getQuantity())));
        }
        this.totalPrice = totalPrice;
    }
}
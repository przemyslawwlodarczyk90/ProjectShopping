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
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User customer;

    @Embedded
    private ShippingAddress shippingAddress;

    @OneToMany(mappedBy = "order")
    private List<LineOfOrder> lineOfOrders;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "sent_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentAt;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate;



    public Order(User customer, ShippingAddress shippingAddress, List<LineOfOrder> lineOfOrders) {
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.lineOfOrders = lineOfOrders;
        this.status = OrderStatus.NEW_ORDER;
        this.creationDate = LocalDate.now();
    }

    public BigDecimal calculateTotalCost() {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (LineOfOrder lineOfOrder : lineOfOrders) {
            totalCost = totalCost.add(lineOfOrder.getUnitPrice().multiply(new BigDecimal(lineOfOrder.getQuantity())));
        }
        return totalCost;
    }
}
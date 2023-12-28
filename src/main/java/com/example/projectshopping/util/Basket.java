package com.example.projectshopping.util;

import com.example.projectshopping.model.entities.order.LineOfOrder;
import com.example.projectshopping.model.entities.order.Order;
import com.example.projectshopping.model.entities.order.ShippingAddress;
import com.example.projectshopping.model.entities.product.Product;
import com.example.projectshopping.model.entities.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineOfOrder> lineOfOrders;

    public void addProduct(Product product) {
        LineOfOrder lineOfOrder = new LineOfOrder();
        lineOfOrder.setProduct(product);
        lineOfOrder.setQuantity(1); // Assuming a quantity of 1 for each product added
        this.lineOfOrders.add(lineOfOrder);
        lineOfOrder.setBasket(this);
    }

    public Order createOrder(User customer, ShippingAddress shippingAddress, List<LineOfOrder> orderLines) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setShippingAddress(shippingAddress);
        order.setLineOfOrders(orderLines);
        return order;
    }
}
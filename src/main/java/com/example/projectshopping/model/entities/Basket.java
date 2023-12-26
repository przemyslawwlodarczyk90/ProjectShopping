package com.example.projectshopping.model.entities;

import com.example.projectshopping.model.entities.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class Basket {

    private List<LineOfOrder> lineOfOrders = new ArrayList<>();

    private Warehouse warehouse;

    public Basket(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Order createOrder(User customer, UserAddress userAddress, ShippingAddress shippingAddress) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setUserAddress(userAddress);
        order.setShippingAddress(shippingAddress);

        // Get the stock levels for all products in the basket
        for (LineOfOrder lineOfOrder : lineOfOrders) {
            Product product = warehouse.getProduct(lineOfOrder.getProduct().getId());

            // Validate product availability
            if (product.getQuantity() < lineOfOrder.getQuantity()) {
                throw new RuntimeException("Product " + product.getName() + " is not available in sufficient quantity.");
            }
        }

        // Decrease the stock levels for all products in the order
        for (LineOfOrder lineOfOrder : lineOfOrders) {
            Product product = lineOfOrder.getProduct();
            int quantityToDeduct = lineOfOrder.getQuantity();

            warehouse.deductProduct(product, quantityToDeduct);
        }

        order.setOrderLines(lineOfOrders);
        order.calculateTotalCost();
        return order;
    }

    public void addProducts(List<Product> products) {
        for (Product product : products) {
            LineOfOrder lineOfOrder = new LineOfOrder();
            lineOfOrder.setProduct(product);
            lineOfOrder.setQuantity(1); // Assuming a quantity of 1 for each product added
            this.lineOfOrders.add(lineOfOrder);
        }
    }
}
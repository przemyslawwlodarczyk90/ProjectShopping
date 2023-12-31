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
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@SessionScope
public class Basket {

    private final List<LineOfOrder> lineOfOrders = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        LineOfOrder lineOfOrder = findLineByProduct(product);
        if (lineOfOrder == null) {
            lineOfOrders.add(new LineOfOrder(product, quantity));
        } else {
            lineOfOrder.setQuantity(lineOfOrder.getQuantity() + quantity);
        }
    }

    public void removeProduct(Product product) {
        LineOfOrder lineOfOrder = findLineByProduct(product);
        if (lineOfOrder != null) {
            if (lineOfOrder.getQuantity() > 1) {
                lineOfOrder.setQuantity(lineOfOrder.getQuantity() - 1);
            } else {
                lineOfOrders.remove(lineOfOrder);
            }
        }
    }

    private LineOfOrder findLineByProduct(Product product) {
        return lineOfOrders.stream()
                .filter(line -> line.getProduct().equals(product))
                .findFirst()
                .orElse(null);
    }

    public List<LineOfOrder> getLineOfOrders() {
        return lineOfOrders;
    }


    public void clear() {
        lineOfOrders.clear();
    }
}

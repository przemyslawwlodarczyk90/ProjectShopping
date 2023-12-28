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

import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket {

    private List<LineOfOrder> lineOfOrders = new ArrayList<>();

    public void addLineOfOrder(LineOfOrder lineOfOrder) {
        lineOfOrders.add(lineOfOrder);
    }

    public Order createOrder() {
        Order order = new Order();
        order.setLineOfOrders(lineOfOrders);
        return order;
    }

    public List<LineOfOrder> getLineOfOrders() {
        return lineOfOrders;
    }

    public void clear() {
        lineOfOrders.clear();
    }
}

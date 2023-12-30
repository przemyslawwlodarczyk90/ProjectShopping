package com.example.projectshopping.notification;

import com.example.projectshopping.model.entities.order.Order;
import com.example.projectshopping.model.entities.product.Observable;

public class Email implements Observer {

    private Order order;

    public Email(Order order) {
        this.order = order;
    }

    @Override
    public void update(Observable observable) {
        if (observable instanceof Order) {
            Order order = (Order) observable;
            System.out.println("E-mail - zamówienie numer: " + order.getId() + " zmieniło status na: " + order.getOrderStatus());
        }
    }

}
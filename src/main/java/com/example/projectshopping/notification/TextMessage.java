package com.example.projectshopping.notification;

import com.example.projectshopping.model.entities.order.Order;
import com.example.projectshopping.model.entities.order.Observable;

public class TextMessage implements Observer {

    private Order order;

    public TextMessage(Order order) {
        this.order = order;
    }

    @Override
    public void update(Observable observable) {
        if (observable instanceof Order) {
            Order order = (Order) observable;
            System.out.println("SMS - zamówienie numer: " + order.getId() + " zmieniło status na: " + order.getOrderStatus());
        }
    }

}
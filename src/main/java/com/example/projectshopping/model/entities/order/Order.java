package com.example.projectshopping.model.entities.order;

import com.example.projectshopping.model.entities.user.User;
import com.example.projectshopping.model.enums.OrderStatus;


import com.example.projectshopping.notification.Observer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Order implements Observable {


    private Long id;

    private User user;


    private OrderStatus orderStatus;



    private LocalDate dateCreated;


    private LocalDate sentAt;


    private List<LineOfOrder> lineOfOrders;

    private BigDecimal totalPrice;

    public void calculateTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (LineOfOrder lineOfOrder : lineOfOrders) {
            totalPrice = totalPrice.add(lineOfOrder.getUnitPrice().multiply(new BigDecimal(lineOfOrder.getQuantity())));
        }
        this.totalPrice = totalPrice;
    }

    @Override
    public void registerObserver(Observer observer) {
        registeredObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        registeredObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : registeredObservers) {
            observer.update(this);
        }
    }

    public void changeOrderStatus(OrderStatus orderStatus) {
        setOrderStatus(orderStatus);
        notifyObservers();
    }

    private void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public LocalDate getSentAt() {
        return sentAt;
    }

    public List<LineOfOrder> getLineOfOrders() {
        return lineOfOrders;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
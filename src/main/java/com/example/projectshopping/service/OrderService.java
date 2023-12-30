package com.example.projectshopping.service;

import com.example.projectshopping.model.entities.order.Order;
import com.example.projectshopping.model.enums.OrderStatus;
import com.example.projectshopping.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAllOrdersByCustomerId(long customerId) {
        return orderRepository.findAllByCustomerId(customerId);
    }

    public List<Order> findAllOrdersByStatus(OrderStatus status) {
        return orderRepository.findAllByStatus(status);
    }

    public List<Order> findAllOrdersByDateCreatedBetween(LocalDate fromDate, LocalDate toDate) {
        return orderRepository.findAllByDateCreatedBetween(fromDate, toDate);
    }

    public Order findOrderById(long id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    public List<Order> findAllOrdersByTotalAmountGreaterThan(BigDecimal totalAmount) {
        return orderRepository.findAllByTotalAmountGreaterThan(totalAmount);
    }

    public List<Order> findAllOrdersByTotalAmountLessThan(BigDecimal totalAmount) {
        return orderRepository.findAllByTotalAmountLessThan(totalAmount);
    }

    public List<Order> findAllOrdersByTotalAmountBetween(BigDecimal fromAmount, BigDecimal toAmount) {
        return orderRepository.findAllByTotalAmountBetween(fromAmount, toAmount);
    }
}
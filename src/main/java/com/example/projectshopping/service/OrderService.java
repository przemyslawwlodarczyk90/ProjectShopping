
package com.example.projectshopping.service;

import com.example.projectshopping.model.entities.order.Order;

import com.example.projectshopping.model.enums.OrderStatus;
import com.example.projectshopping.model.repository.OrderRepository;
import com.example.projectshopping.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {


  private OrderRepository orderRepository;

  private UserRepository userRepository;

  public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
    this.orderRepository = orderRepository;
    this.userRepository = userRepository;
  }

  public List<Order> findAllOrders() {
    return orderRepository.findAll();
  }


  public List<Order> findAllOrdersByUserId(Long userId) {
    return orderRepository.findAllOrdersByUserId(userId);
  }



  public List<Order> findAllOrdersByStatus(OrderStatus status) {
    return orderRepository.findAllByOrderStatus(status);
  }

  public Order findOrderById(Long id) {
    return orderRepository.findById(id).orElse(null);
  }

  public Order saveOrder(Order order) {
    return orderRepository.save(order);
  }

  public void deleteOrder(Order order) {
    orderRepository.delete(order);
  }


}
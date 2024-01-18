package com.example.projectshopping.model.repository;

import com.example.projectshopping.model.entities.order.Order;
import com.example.projectshopping.model.enums.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
class InMemoryOrderRepository implements OrderRepository {

  private Map<Long, Order> orders = new HashMap<>();
  private Long currentId = 1L;

  @Override
  public List<Order> findAllOrdersByUserId(long userId) {
    return orders.values().stream()
            .filter(order -> order.getAccountHolder() != null && order.getAccountHolder().getId() == userId)
            .collect(Collectors.toList());
  }
  @Override
  public List<Order> findAllByOrderStatus(OrderStatus orderStatus) {
    return orders.values().stream()
            .filter(order -> order.getOrderStatus() == orderStatus)
            .collect(Collectors.toList());
  }



  @Override
  public Optional<Order> findById(long id) {
    return Optional.ofNullable(orders.get(id));
  }

  @Override
  public Order save(Order order) {
    if (order.getId() == null) {
      order.setId(currentId++);
    }
    orders.put(order.getId(), order);
    return order;
  }

  @Override
  public void delete(Order order) {
    orders.remove(order.getId());
  }



  @Override
  public List<Order> findAll() {
    return new ArrayList<>(orders.values());
  }
}
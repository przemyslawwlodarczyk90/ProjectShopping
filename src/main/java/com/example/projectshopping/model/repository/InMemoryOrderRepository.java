package com.example.projectshopping.model.repository;

import com.example.projectshopping.model.entities.order.Order;
import com.example.projectshopping.model.enums.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
class InMemoryOrderRepository implements OrderRepository {

  @Override
  public List<Order> findAllOrdersByUserId(long userId) {
    return null;
  }

  @Override
  public List<Order> findAllByOrderStatus(OrderStatus orderStatus) {
    return null;
  }

  @Override
  public List<Order> findAllByDateCreatedBetween(LocalDate fromDate, LocalDate toDate) {
    return null;
  }

  @Override
  public Optional<Order> findById(long id) {
    return Optional.empty();
  }

  @Override
  public Order save(Order order) {
    return null;
  }

  @Override
  public void delete(Order order) {

  }

  @Override
  public List<Order> findAllByTotalPriceGreaterThan(BigDecimal totalPrice) {
    return null;
  }

  @Override
  public List<Order> findAllByTotalPriceLessThan(BigDecimal totalPrice) {
    return null;
  }

  @Override
  public List<Order> findAllByTotalPriceBetween(BigDecimal fromPrice, BigDecimal toPrice) {
    return null;
  }

  @Override
  public List<Order> findAll() {
    return null;
  }
}

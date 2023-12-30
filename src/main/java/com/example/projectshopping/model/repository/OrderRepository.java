package com.example.projectshopping.model.repository;

import com.example.projectshopping.model.entities.order.Order;
import com.example.projectshopping.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>,
        CrudRepository<Order, Long> {

    List<Order> findAllByCustomerId(long customerId);

    List<Order> findAllByStatus(OrderStatus status);

    List<Order> findAllByDateCreatedBetween(LocalDate fromDate, LocalDate toDate);

    Order findById(long id);

    Order save(Order order);

    void delete(Order order);

    List<Order> findAllByTotalAmountGreaterThan(BigDecimal totalAmount);

    List<Order> findAllByTotalAmountLessThan(BigDecimal totalAmount);

    List<Order> findAllByTotalAmountBetween(BigDecimal fromAmount, BigDecimal toAmount);
}
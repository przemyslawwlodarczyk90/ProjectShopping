
package com.example.projectshopping.service;

import com.example.projectshopping.model.dto.LineOfOrderDTO;
import com.example.projectshopping.model.dto.OrderDTO;
import com.example.projectshopping.model.entities.order.Order;

import com.example.projectshopping.model.entities.user.User;
import com.example.projectshopping.model.enums.OrderStatus;
import com.example.projectshopping.model.repository.OrderRepository;
import com.example.projectshopping.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  // Istniejące metody...

  public List<OrderDTO> findAllOrderDTOs() {
    return orderRepository.findAll().stream()
            .map(this::convertToOrderDTO)
            .collect(Collectors.toList());
  }

  public OrderDTO findOrderDTOById(Long id) {
    return orderRepository.findById(id)
            .map(this::convertToOrderDTO)
            .orElse(null);
  }

  public OrderDTO saveOrderDTO(OrderDTO orderDTO) {
    Order order = convertToOrder(orderDTO);
    return convertToOrderDTO(orderRepository.save(order));
  }

  public OrderDTO updateOrderDTO(Long id, OrderDTO orderDTO) {
    Order existingOrder = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));
    updateOrderData(existingOrder, orderDTO);
    return convertToOrderDTO(orderRepository.save(existingOrder));
  }

  private OrderDTO convertToOrderDTO(Order order) {
    List<LineOfOrderDTO> lineOfOrdersDTO = order.getLineOfOrders().stream()
            .map(line -> new LineOfOrderDTO(
                    line.getId(),
                    line.getProduct().getId(),
                    line.getQuantity(),
                    line.getUnitPrice()))
            .collect(Collectors.toList());

    return OrderDTO.builder()
            .id(order.getId())
            .userId(order.getUser().getId())
            .orderStatus(order.getOrderStatus().name())
            .dateCreated(order.getDateCreated())
            .sentAt(order.getSentAt())
            .totalPrice(order.getTotalPrice())
            .lineOfOrders(lineOfOrdersDTO)
            .build();
  }

  private Order convertToOrder(OrderDTO orderDTO) {
    // Znajdź istniejące zamówienie lub stwórz nowe
    Order order = orderRepository.findById(orderDTO.id())
            .orElse(new Order());

    // Ustawienie użytkownika i pozostałych pól
    // Zakładam, że obiekt User jest już związany z Order
    order.setOrderStatus(OrderStatus.valueOf(orderDTO.orderStatus()));
    // Lista LineOfOrder musi być zaimplementowana w odpowiedni sposób
    // order.setLineOfOrders(convertLineOfOrdersDTO(orderDTO.lineOfOrders()));

    order.calculateTotalPrice(); // Oblicz cenę całkowitą
    return order;
  }

  private void updateOrderData(Order order, OrderDTO orderDTO) {
    order.setOrderStatus(OrderStatus.valueOf(orderDTO.orderStatus()));
    // Aktualizacja innych pól, jeśli jest to konieczne
    // Na przykład aktualizacja linii zamówienia, jeśli struktura DTO to wymaga
  }
}
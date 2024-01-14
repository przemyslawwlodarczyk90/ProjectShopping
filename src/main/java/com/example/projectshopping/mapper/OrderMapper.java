//package com.example.projectshopping.mapper;
//
//import com.example.projectshopping.model.dto.OrderDTO;
//import com.example.projectshopping.model.entities.order.Order;
//import com.example.projectshopping.model.enums.OrderStatus;
//
//public class OrderMapper {
//
//    public static Order toEntity(OrderDTO dto) {
//        Order order = new Order();
//        order.setId(dto.getId());
//        // Ustaw pozostałe pola na podstawie DTO, uwzględnij relacje i zależności
//        return order;
//    }
//
//    public static OrderDTO toDTO(Order order) {
//        OrderDTO dto = new OrderDTO();
//        dto.setId(order.getId());
//        dto.setUserId(order.getUser() != null ? order.getUser().getId() : null);
//        dto.setOrderStatus(order.getOrderStatus().name());
//        dto.setDateCreated(order.getDateCreated());
//        dto.setSentAt(order.getSentAt());
//        dto.setTotalPrice(order.getTotalPrice());
//        // Konwertuj LineOfOrders na LineOfOrderDTO i ustaw w dto
//        return dto;
//    }
//}
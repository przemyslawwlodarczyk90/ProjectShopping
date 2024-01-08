package com.example.projectshopping.controller;

import com.example.projectshopping.mapper.OrderMapper;
import com.example.projectshopping.model.dto.OrderDTO;
import com.example.projectshopping.model.entities.order.Order;
import com.example.projectshopping.model.enums.OrderStatus;
import com.example.projectshopping.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String listOrders(Model model) {
        List<Order> orders = orderService.findAllOrders();
        List<OrderDTO> orderDTOs = orders.stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
        model.addAttribute("orders", orderDTOs);
        return "order_list";
    }

    @GetMapping("/{orderId}")
    public String orderDetails(@PathVariable Long orderId, Model model) {
        Order order = orderService.findOrderById(orderId);
        OrderDTO orderDTO = OrderMapper.toDTO(order);
        model.addAttribute("order", orderDTO);
        return "order_details";
    }

    @GetMapping("/edit/{orderId}")
    public String editOrderForm(@PathVariable Long orderId, Model model) {
        OrderDTO orderDTO = OrderMapper.toDTO(orderService.findOrderById(orderId));
        model.addAttribute("orderDTO", orderDTO);
        return "order_edit_form";
    }

    @PostMapping("/edit/{orderId}")
    public String updateOrder(@PathVariable Long orderId, @ModelAttribute OrderDTO orderDTO) {
        orderService.saveOrder(OrderMapper.toEntity(orderDTO));
        return "redirect:/orders";
    }

    @GetMapping("/user/{userId}")
    public String listOrdersByUser(@PathVariable Long userId, Model model) {
        List<Order> orders = orderService.findAllOrdersByUserId(userId);
        List<OrderDTO> orderDTOs = orders.stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
        model.addAttribute("orders", orderDTOs);
        return "order_list_by_user";
    }

}



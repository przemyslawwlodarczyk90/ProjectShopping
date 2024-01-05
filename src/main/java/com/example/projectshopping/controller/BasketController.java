package com.example.projectshopping.controller;

import com.example.projectshopping.model.entities.order.Order;
import com.example.projectshopping.service.BasketService;
import com.example.projectshopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basket")
public class BasketController {

    // Wstrzyknięcie zależności BasketService i OrderService
    private final BasketService basketService;
    private final OrderService orderService;

    @Autowired
    public BasketController(BasketService basketService, OrderService orderService) {
        this.basketService = basketService;
        this.orderService = orderService;
    }

    @GetMapping("/checkout")
    public String checkoutForm(Model model) {
        // Przygotowanie pustego obiektu Order do formularza
        model.addAttribute("order", new Order());
        return "order_checkout_form";
    }

    @PostMapping("/checkout")
    public String processCheckout(@ModelAttribute Order order) {
        // Procesowanie zamówienia na podstawie danych z koszyka
        // Dodanie produktów z koszyka do zamówienia, obliczenie ceny, zapisanie zamówienia
        orderService.saveOrder(order); // zapisanie zamówienia w bazie danych
        basketService.clear(); // czyszczenie koszyka po finalizacji zamówienia
        return "redirect:/orders/success"; // przekierowanie na stronę potwierdzenia zamówienia
    }
}
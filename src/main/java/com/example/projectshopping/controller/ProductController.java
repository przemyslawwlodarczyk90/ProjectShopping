package com.example.projectshopping.controller;

import com.example.projectshopping.model.entities.product.Product;
import com.example.projectshopping.model.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> products = (List<Product>) productRepository.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/addProduct")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        // Dodaj tu inne potrzebne atrybuty, np. listy dla dropdownów
        return "addProduct";
    }

    @GetMapping("/searchProducts")
    public String searchProducts(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "category", required = false) Long categoryId,
            @RequestParam(name = "minPrice", required = false) BigDecimal minPrice,
            @RequestParam(name = "maxPrice", required = false) BigDecimal maxPrice,
            @RequestParam(name = "author", required = false) String author,
            Model model
    ) {
        // Tutaj wywołujesz odpowiednie metody z serwisu w zależności od parametrów
        // Następnie przekazujesz wyniki wyszukiwania do widoku Thymeleaf

        return "searchResults"; // To jest nazwa widoku, którego jeszcze nie utworzyliśmy
    }
}
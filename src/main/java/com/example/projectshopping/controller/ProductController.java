package com.example.projectshopping.controller;

import com.example.projectshopping.model.entities.product.Product;
import com.example.projectshopping.model.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
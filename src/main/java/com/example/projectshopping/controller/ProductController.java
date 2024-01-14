package com.example.projectshopping.controller;

import com.example.projectshopping.model.dto.ProductDTO;
import com.example.projectshopping.mapper.ProductMapper;
import com.example.projectshopping.model.entities.product.Product;
import com.example.projectshopping.model.repository.ProductRepository;

import com.example.projectshopping.service.BasketService;
import com.example.projectshopping.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
public class ProductController {


    private ProductRepository productRepository;


    private ProductService productService;


    private BasketService basketService;

    public ProductController(ProductRepository productRepository, ProductService productService, BasketService basketService) {
        this.productRepository = productRepository;
        this.productService = productService;
        this.basketService = basketService;
    }


    @GetMapping
    public String listProducts(@RequestParam(name = "viewType", defaultValue = "grid") String viewType, Model model) {
        List<Product> products = productService.findAllProducts();
        List<ProductDTO> productDTOs = products.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
        model.addAttribute("products", productDTOs);
        return viewType.equals("list") ? "products_list" : "products_grid";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        return "product_add";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductDTO productDTO) {
        productService.saveProduct(ProductMapper.toEntity(productDTO));
        return "redirect:/products";
    }




    @GetMapping("/basket/add/{productId}")
    public String addProductToBasket(@PathVariable Long productId, RedirectAttributes redirectAttributes) {
        Product product = productService.findProductById(productId);
        if (product != null) {
            basketService.addProduct(product);
            redirectAttributes.addFlashAttribute("success", "Produkt dodany do koszyka.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Produkt nie znaleziony.");
        }

        return "redirect:/products";}

    @GetMapping("/basket/remove/{productId}")
    public String removeProductFromBasket(@PathVariable Long productId, RedirectAttributes redirectAttributes) {
        Product product = productService.findProductById(productId);
        if (product != null) {
            basketService.removeProduct(product);
            redirectAttributes.addFlashAttribute("success", "Produkt usunięty z koszyka.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Produkt nie znaleziony.");
        }
        return "redirect:/basket";
    }
}
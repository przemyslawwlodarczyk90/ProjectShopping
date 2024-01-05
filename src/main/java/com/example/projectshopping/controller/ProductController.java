package com.example.projectshopping.controller;

import com.example.projectshopping.model.entities.product.Product;
import com.example.projectshopping.model.repository.ProductRepository;

import com.example.projectshopping.service.BasketService;
import com.example.projectshopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;

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
        model.addAttribute("products", products);
        return viewType.equals("list") ? "products_list" : "products_grid";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        // Dodaj tu inne potrzebne atrybuty, np. listy dla dropdownów
        return "product_add";
    }

    @GetMapping("/search")
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

        return "product_search_results"; // To jest nazwa widoku, którego jeszcze nie utworzyliśmy
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
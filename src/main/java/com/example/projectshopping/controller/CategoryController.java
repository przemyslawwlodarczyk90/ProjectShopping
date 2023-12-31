package com.example.projectshopping.controller;

import com.example.projectshopping.model.entities.product.Category;
import com.example.projectshopping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("allCategories", categoryService.getAllCategories());
        return "add-category"; // Nazwa szablonu Thymeleaf
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category) {
        categoryService.addCategory(category);
        return "redirect:/categories"; // Przekierowanie do listy kategorii po dodaniu
    }

    @GetMapping
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories"; // Nazwa szablonu Thymeleaf do wyświetlania kategorii
    }

    @GetMapping("/categoryTree")
    public String showCategoryTree(Model model) {
        List<Category> categories = categoryService.getAllCategories(); // lub getTopLevelCategories()
        model.addAttribute("categories", categories);
        return "categoryTree"; // nazwa widoku Thymeleaf
    }


}
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

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories"; // Nazwa szablonu Thymeleaf do wyświetlania kategorii
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("allCategories", categoryService.getAllCategories());
        return "category_add"; // Nazwa szablonu Thymeleaf
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category) {
        categoryService.addCategory(category);
        return "redirect:/categories"; // Przekierowanie do listy kategorii po dodaniu
    }

    @GetMapping("/tree")
    public String showCategoryTree(Model model) {
        List<Category> categories = categoryService.getAllCategories(); // lub getTopLevelCategories()
        model.addAttribute("categories", categories);
        return "category_tree"; // nazwa widoku Thymeleaf
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "category_edit";
    }

    @PostMapping("/edit/{id}")
    public String editCategory(@PathVariable Long id, @ModelAttribute Category category) {
        categoryService.updateCategory(id, category);
        return "redirect:/categories";
    }


}
package com.example.projectshopping.controller;

import com.example.projectshopping.mapper.CategoryMapper;
import com.example.projectshopping.model.dto.CategoryDTO;
import com.example.projectshopping.model.entities.product.Category;
import com.example.projectshopping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listCategories(Model model) {
        List<CategoryDTO> categories = categoryService.getAllCategories().stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("categoryDTO", new CategoryDTO());
        return "category_add";
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
        CategoryDTO categoryDTO = CategoryMapper.toDTO(categoryService.getCategoryById(id));
        model.addAttribute("categoryDTO", categoryDTO);
        return "category_edit";
    }

    @PostMapping("/edit/{id}")
    public String editCategory(@PathVariable Long id, @ModelAttribute CategoryDTO categoryDTO) {
        categoryService.updateCategory(id, CategoryMapper.toEntity(categoryDTO));
        return "redirect:/categories";
    }


}
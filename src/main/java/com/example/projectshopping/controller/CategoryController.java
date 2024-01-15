package com.example.projectshopping.controller;


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

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listCategories(Model model) {
        List<CategoryDTO> categories = categoryService.getAllCategoryDTOs();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("categoryDTO", new CategoryDTO(null, "", null));
        return "category_add";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.name());
        // Ustaw parentCategory, jeśli jest wymagane
        categoryService.addCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable Long id, Model model) {
        CategoryDTO categoryDTO = categoryService.getCategoryDTOById(id);
        model.addAttribute("categoryDTO", categoryDTO);
        return "category_edit";
    }


    @PostMapping("/edit/{id}")
    public String editCategory(@PathVariable Long id, @ModelAttribute CategoryDTO categoryDTO) {
        categoryService.updateCategoryDTO(id, categoryDTO);
        return "redirect:/categories";
    }


}
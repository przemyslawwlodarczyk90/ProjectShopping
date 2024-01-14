//package com.example.projectshopping.mapper;
//
//import com.example.projectshopping.model.dto.CategoryDTO;
//import com.example.projectshopping.model.entities.product.Category;
//
//public class CategoryMapper {
//
//    public static CategoryDTO toDTO(Category category) {
//        CategoryDTO dto = new CategoryDTO();
//        dto.setId(category.getId());
//        dto.setName(category.getName());
//        dto.setParentCategoryId(category.getParentCategory() != null ? category.getParentCategory().getId() : null);
//        return dto;
//    }
//
//    public static Category toEntity(CategoryDTO dto) {
//        Category category = new Category();
//        category.setId(dto.getId());
//        category.setName(dto.getName());
//        // Ustawienie parentCategory wymaga dodatkowej logiki, np. wyszukanie w bazie danych
//        return category;
//    }
//}
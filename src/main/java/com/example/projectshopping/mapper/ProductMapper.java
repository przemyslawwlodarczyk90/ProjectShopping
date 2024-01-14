//package com.example.projectshopping.mapper;
//
//import com.example.projectshopping.model.dto.ProductDTO;
//import com.example.projectshopping.model.entities.product.Product;
//
//public class ProductMapper {
//
//    public static ProductDTO toDTO(Product product) {
//        ProductDTO dto = new ProductDTO();
//        dto.setId(product.getId());
//        dto.setTitle(product.getTitle());
//        dto.setDescription(product.getDescription());
//        dto.setPrice(product.getPrice());
//        dto.setProductType(product.getProductType());
//        return dto;
//    }
//
//    public static Product toEntity(ProductDTO dto) {
//        Product product = new Product();
//        product.setId(dto.getId());
//        product.setTitle(dto.getTitle());
//        product.setDescription(dto.getDescription());
//        product.setPrice(dto.getPrice());
//        product.setProductType(dto.getProductType());
//        return product;
//    }
//}
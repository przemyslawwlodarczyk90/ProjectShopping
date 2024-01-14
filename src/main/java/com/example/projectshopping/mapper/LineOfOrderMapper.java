//package com.example.projectshopping.mapper;
//
//import com.example.projectshopping.model.dto.LineOfOrderDTO;
//import com.example.projectshopping.model.entities.order.LineOfOrder;
//import com.example.projectshopping.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class LineOfOrderMapper {
//
//    private final ProductService productService;
//
//    @Autowired
//    public LineOfOrderMapper(ProductService productService) {
//        this.productService = productService;
//    }
//
//    public LineOfOrderDTO toDTO(LineOfOrder lineOfOrder) {
//        LineOfOrderDTO dto = new LineOfOrderDTO();
//        dto.setId(lineOfOrder.getId());
//        dto.setProductId(lineOfOrder.getProduct().getId());
//        dto.setQuantity(lineOfOrder.getQuantity());
//        dto.setUnitPrice(lineOfOrder.getUnitPrice());
//        return dto;
//    }
//
//    public LineOfOrder toEntity(LineOfOrderDTO lineOfOrderDTO) {
//        LineOfOrder lineOfOrder = new LineOfOrder();
//        lineOfOrder.setProduct(productService.findProductById(lineOfOrderDTO.getProductId()));
//        lineOfOrder.setQuantity(lineOfOrderDTO.getQuantity());
//        lineOfOrder.setUnitPrice(lineOfOrderDTO.getUnitPrice());
//        return lineOfOrder;
//    }
//}
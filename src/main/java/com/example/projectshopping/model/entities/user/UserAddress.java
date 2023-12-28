package com.example.projectshopping.model.entities.user;

import com.example.projectshopping.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {

    private String street;

    private String city;

    private String postalCode;

    private String country;

}


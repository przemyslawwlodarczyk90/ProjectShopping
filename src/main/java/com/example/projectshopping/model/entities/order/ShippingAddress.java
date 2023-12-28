package com.example.projectshopping.model.entities.order;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddress {

    private String street;

    private String city;

    private String postalCode;

    private String country;
}
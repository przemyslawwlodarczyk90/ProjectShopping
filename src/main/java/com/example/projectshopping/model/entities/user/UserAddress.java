package com.example.projectshopping.model.entities.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


package com.example.projectshopping.model.form;

import lombok.Data;

@Data
public class RegistrationForm {

    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
}
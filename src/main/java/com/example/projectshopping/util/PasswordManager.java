package com.example.projectshopping.util;

import com.example.projectshopping.model.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.UUID;

@Component
public class PasswordManager {

    private final PasswordEncoder passwordEncoder;

    public PasswordManager(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encode(String password) {
        String salt = UUID.randomUUID().toString();
        return passwordEncoder.encode(password + salt);
    }

    public void verifyPassword(String rawPassword, String hashedPassword) {
        Assert.isTrue(passwordEncoder.matches(rawPassword, hashedPassword), "Invalid password");
    }

    private void resetPassword(User userAccount) {
        String newPassword = UUID.randomUUID().toString();
        userAccount.setPasswordHash(passwordEncoder.encode(newPassword));
    }
}
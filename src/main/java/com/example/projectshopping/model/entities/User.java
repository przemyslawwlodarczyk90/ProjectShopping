package com.example.projectshopping.model.entities;

import com.example.projectshopping.model.enums.AdminOrUser;
import com.example.projectshopping.util.PasswordManager;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    @Column(name = "name")
    private String firstName;

    @Column(name = "surname")
    private String lastName;

    @Column(name = "password_hash")
    private String passwordHash;

    @Embedded
    private UserAddress address;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "avatar_path")
    private String avatarPath;

    @Enumerated(EnumType.STRING)
    private AdminOrUser adminOrUser;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public User(String email, String passwordHash, String avatarPath, String firstName, String lastName) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.avatarPath = avatarPath;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String email, String passwordHash, String avatarPath, String firstName, String lastName, PasswordManager passwordManager) {
        this.email = email;
        this.passwordHash = passwordManager.encode(passwordHash);
        this.avatarPath = avatarPath;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
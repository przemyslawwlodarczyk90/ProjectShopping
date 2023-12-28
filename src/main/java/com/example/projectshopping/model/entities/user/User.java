package com.example.projectshopping.model.entities.user;

import com.example.projectshopping.model.entities.order.Order;
import com.example.projectshopping.model.enums.AdminOrUser;
import com.example.projectshopping.util.PasswordManager;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
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

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany
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

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }

}
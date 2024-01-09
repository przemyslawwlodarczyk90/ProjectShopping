package com.example.projectshopping.model.entities.user;

import com.example.projectshopping.model.entities.order.Order;
import com.example.projectshopping.model.enums.AdminOrUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;
import java.util.Set;

public class User {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private String passwordHash;

    private UserAddress address;

    private int phoneNumber;

    private String avatarPath;

    private AdminOrUser adminOrUser;

    private Date createdAt;

    private Date updatedAt;

    private Set<Order> orders;

    public User(String email, String passwordHash, String avatarPath, String firstName, String lastName) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.avatarPath = avatarPath;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }

    public User addOrder(Order order) {
        this.orders.add(order);
        return this;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public UserAddress getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public AdminOrUser getAdminOrUser() {
        return adminOrUser;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public void setAdminOrUser(AdminOrUser adminOrUser) {
        this.adminOrUser = adminOrUser;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
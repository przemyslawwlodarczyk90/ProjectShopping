package com.example.projectshopping.model.entities.user;

import com.example.projectshopping.model.entities.order.Order;
import com.example.projectshopping.model.enums.AdminOrUser;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
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

    // poniżej były problemy ze słowem zastrzeżonym user i musiałem zamienić accountHolder
    @OneToMany(mappedBy = "accountHolder")
    private Set<Order> orders;

    public User(String email, String passwordHash, String avatarPath, String firstName, String lastName) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.avatarPath = avatarPath;
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    public User(String email, String passwordHash, String avatarPath, String firstName, String lastName, PasswordManager passwordManager) {
//        this.email = email;
//        this.passwordHash = passwordManager.encode(passwordHash);
//        this.avatarPath = avatarPath;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }

    public User addOrder(Order order) {
        this.orders.add(order);
        return this;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }
}
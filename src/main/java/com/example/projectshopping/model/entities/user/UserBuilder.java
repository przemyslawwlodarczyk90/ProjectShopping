//package com.example.projectshopping.model.entities.user;
//
//import com.example.projectshopping.model.enums.AdminOrUser;
//
//import lombok.Builder;
//
//@Builder
//public class UserBuilder {
//
//    @Builder.Default
//    private String firstName = "";
//
//    @Builder.Default
//    private String lastName = "";
//
//    private String email;
//
////    private PasswordManager passwordManager;
//
//    private String passwordHash;
//
//    private UserAddress address;
//
//    private int phoneNumber;
//
//    private String avatarPath;
//
//    private AdminOrUser adminOrUser;
//
//    public User build() {
//        User user = new User(email, passwordManager.encode(passwordHash), avatarPath, firstName, lastName);
//        user.setAdminOrUser(adminOrUser);
//        return user;
//    }
//}
package com.example.projectshopping.mapper;

import com.example.projectshopping.model.dto.UserDTO;
import com.example.projectshopping.model.entities.user.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName()
                // Dodaj tu pozostałe mapowania, jeśli są potrzebne
        );
    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        // Tutaj ustawiasz pozostałe pola encji User, jeśli są potrzebne
        return user;
    }
}
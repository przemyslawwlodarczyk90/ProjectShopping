package com.example.projectshopping.controller;

import com.example.projectshopping.mapper.UserMapper;
import com.example.projectshopping.model.dto.UserDTO;
import com.example.projectshopping.model.entities.user.User;
import com.example.projectshopping.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.findAllUsers();
        List<UserDTO> userDTOs = users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
        model.addAttribute("users", userDTOs);
        return "users/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        UserDTO userDTO = UserMapper.toDTO(userService.findUserById(id));
        model.addAttribute("userDTO", userDTO);
        return "users/edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, @ModelAttribute UserDTO userDTO) {
        userService.saveUser(UserMapper.toEntity(userDTO));
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
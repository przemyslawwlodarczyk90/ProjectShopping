package com.example.projectshopping.controller;

import com.example.projectshopping.model.dto.UserDTO;
import com.example.projectshopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        List<UserDTO> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<UserDTO> userDTO = userService.findUserById(id);
        userDTO.ifPresent(dto -> model.addAttribute("userDTO", dto));
        return userDTO.isPresent() ? "users/edit" : "redirect:/users";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute UserDTO userDTO) {
        userService.updateUser(id, userDTO);
        return "redirect:/users";
    }

    @GetMapping("/new")
    public String showNewUserForm(Model model) {
        model.addAttribute("userDTO", new UserDTO(null, "", "", ""));
        return "users/new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute UserDTO userDTO) {
        userService.saveUser(userDTO);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/search/email")
    public String findUserByEmail(@RequestParam String email, Model model) {
        Optional<UserDTO> userDTO = userService.findUserByEmail(email);
        userDTO.ifPresent(dto -> model.addAttribute("user", dto));
        return userDTO.isPresent() ? "users/details" : "redirect:/users";
    }

    @GetMapping("/search/username")
    public String findUserByUsername(@RequestParam String username, Model model) {
        Optional<UserDTO> userDTO = userService.findUserByUsername(username);
        userDTO.ifPresent(dto -> model.addAttribute("user", dto));
        return userDTO.isPresent() ? "users/details" : "redirect:/users";
    }
}
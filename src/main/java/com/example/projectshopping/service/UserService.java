package com.example.projectshopping.service;

import com.example.projectshopping.model.entities.user.User;
import com.example.projectshopping.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsernameIgnoreCaseContaining(username);
    }

    public List<User> findAllUsersByLastLoginDateBetween(LocalDate fromDate, LocalDate toDate) {
        return userRepository.findAllByLastLoginDateBetween(fromDate, toDate);
    }

    public User saveUser(User user) {
        // Save the user to the database
        userRepository.save(user);

        // Return the saved user
        return user;
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }


}
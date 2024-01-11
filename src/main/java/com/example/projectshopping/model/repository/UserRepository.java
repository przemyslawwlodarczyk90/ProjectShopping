package com.example.projectshopping.model.repository;

import com.example.projectshopping.model.entities.user.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


public interface UserRepository {

    User findByEmail(String email);

    User findByUsernameIgnoreCaseContaining(String username);



    User save(User user);

    void delete(User user);

    List<User> findAll();

    Optional<User> findById(Long id);

    void deleteById(Long id);
}
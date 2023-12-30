package com.example.projectshopping.model.repository;

import com.example.projectshopping.model.entities.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    User findByUsernameIgnoreCaseContaining(String username);

    List<User> findAllByLastLoginDateBetween(LocalDate fromDate, LocalDate toDate);

    User save(User user);

    void delete(User user);

}
package com.example.projectshopping.model.repository;

import com.example.projectshopping.model.entities.user.User;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
class InMemoryUserRepository implements UserRepository {

  private static User testUser = new User();
  @Override
  public User findByEmail(String email) {
    return testUser;
  }

  @Override
  public User findByUsernameIgnoreCaseContaining(String username) {
    return null;
  }

  @Override
  public List<User> findAllByLastLoginDateBetween(LocalDate fromDate, LocalDate toDate) {
    return null;
  }

  @Override
  public User save(User user) {
    return null;
  }

  @Override
  public void delete(User user) {

  }

  @Override
  public List<User> findAll() {
    return null;
  }

  @Override
  public Optional<User> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public void deleteById(Long id) {

  }
}

package com.example.projectshopping.model.repository;

import com.example.projectshopping.model.entities.user.User;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
class InMemoryUserRepository implements UserRepository {

  private static User testUser = new User();
  private Map<Long, User> users = new HashMap<>();
  private Long currentId = 1L;


  @Override
  public User findByEmail(String email) {
    return users.values().stream()
            .filter(user -> user.getEmail().equalsIgnoreCase(email))
            .findFirst()
            .orElse(null);
  }


  @Override
  public User findByUsernameIgnoreCaseContaining(String username) {
    return users.values().stream()
            .filter(user -> (user.getFirstName() + " " + user.getLastName()).toLowerCase().contains(username.toLowerCase()))
            .findFirst()
            .orElse(null);
  }



  @Override
  public User save(User user) {
    if (user.getId() == null) {
      user.setId(currentId++);
    }
    users.put(user.getId(), user);
    return user;
  }

  @Override
  public void delete(User user) {
    users.remove(user.getId());
  }

  @Override
  public List<User> findAll() {
    return new ArrayList<>(users.values());
  }

  @Override
  public Optional<User> findById(Long id) {
    return Optional.ofNullable(users.get(id));
  }

  @Override
  public void deleteById(Long id) {
    users.remove(id);
  }
}

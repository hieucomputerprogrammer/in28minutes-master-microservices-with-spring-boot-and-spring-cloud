package ai.tech.service;

import ai.tech.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
  User save(User user);

  List<User> findAll();

  User findById(UUID uuid);

  void deleteById(UUID uuid);
}

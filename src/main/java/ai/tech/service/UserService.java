package ai.tech.service;

import ai.tech.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
  Optional<User> save(User user);

  Optional<List<User>> findAll();

  Optional<User> findById(UUID uuid);

  void deleteById(UUID uuid);
}

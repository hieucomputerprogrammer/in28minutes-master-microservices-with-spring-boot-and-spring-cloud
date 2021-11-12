package ai.tech.service.impl;

import ai.tech.domain.User;
import ai.tech.repository.UserJpaRepository;
import ai.tech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
  private final UserJpaRepository userRepository;

  @Override
  public Optional<User> save(User user) {
    return Optional.of(this.userRepository.save(user));
  }

  @Override
  public Optional<List<User>> findAll() {
    return Optional.of(this.userRepository.findAll());
  }

  @Override
  public Optional<User> findById(UUID uuid) {
    return Optional.of(this.userRepository.findById(uuid).get());
  }

  @Override
  public void deleteById(UUID uuid) {
    this.userRepository.deleteById(uuid);
  }
}

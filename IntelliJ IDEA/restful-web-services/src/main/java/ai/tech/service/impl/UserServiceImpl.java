package ai.tech.service.impl;

import ai.tech.domain.User;
import ai.tech.repository.UserRepository;
import ai.tech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  public User save(User user) {
    return this.userRepository.save(user);
  }

  @Override
  public List<User> findAll() {
    return this.userRepository.findAll();
  }

  @Override
  public User findById(UUID uuid) {
    return this.userRepository.findById(uuid);
  }

  @Override
  public void deleteById(UUID uuid) {
    this.userRepository.deleteById(uuid);
  }
}

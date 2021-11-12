package ai.tech.service.impl;

import ai.tech.domain.Post;
import ai.tech.repository.PostJpaRepository;
import ai.tech.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
  private final PostJpaRepository postRepository;

  @Override
  public Optional<Post> save(final Post post) {
    return Optional.of(this.postRepository.save(post));
  }

  @Override
  public Optional<List<Post>> findAll() {
    return Optional.of(this.postRepository.findAll());
  }

  @Override
  public Optional<Post> findById(final UUID uuid) {
    return Optional.of(this.postRepository.findById(uuid).get());
  }

  @Override
  public void deleteById(final UUID uuid) {
    this.postRepository.deleteById(uuid);
  }
}

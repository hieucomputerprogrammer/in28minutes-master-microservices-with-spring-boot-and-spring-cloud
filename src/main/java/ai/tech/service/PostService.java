package ai.tech.service;

import ai.tech.domain.Post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostService {
  Optional<Post> save(Post post);

  Optional<List<Post>> findAll();

  Optional<Post> findById(UUID uuid);

  void deleteById(UUID uuid);
}

package ai.tech.service;

import ai.tech.domain.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
  Post save(Post post);

  List<Post> findAll();

  Post findById(UUID uuid);

  void deleteById(UUID uuid);
}

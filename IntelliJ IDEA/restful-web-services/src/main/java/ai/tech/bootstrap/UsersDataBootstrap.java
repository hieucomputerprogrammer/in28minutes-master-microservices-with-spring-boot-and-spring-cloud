package ai.tech.bootstrap;

import ai.tech.domain.User;
import ai.tech.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class UsersDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {
  private final UserJpaRepository userRepository;

  @Override
  @Transactional
  public void onApplicationEvent(final ContextRefreshedEvent event) {
    this.initUsersData();
    log.info("Initialized users data.");
  }

  private void initUsersData() {
    this.userRepository.save(
        User.builder()
            .uuid(UUID.randomUUID())
            .name("Hieu")
            .birthday(Timestamp.valueOf("1994-07-13 00:00:00"))
            .build());
    this.userRepository.save(
        User.builder()
            .uuid(UUID.randomUUID())
            .name("James Gosling")
            .birthday(Timestamp.valueOf("1955-05-19 00:00:00"))
            .build());
    this.userRepository.save(
        User.builder()
            .uuid(UUID.randomUUID())
            .name("Guido Van Rossum")
            .birthday(Timestamp.valueOf("1956-01-31 00:00:00"))
            .build());
    this.userRepository.save(
            User.builder()
                    .uuid(UUID.randomUUID())
                    .name("Tim Berners-Lee")
                    .birthday(Timestamp.valueOf("1955-06-08 00:00:00"))
                    .build());
    this.userRepository.save(
            User.builder()
                    .uuid(UUID.randomUUID())
                    .name("Vinton Gray \"Vint\" Cerf")
                    .birthday(Timestamp.valueOf("1943-06-23 00:00:00"))
                    .build());
  }
}

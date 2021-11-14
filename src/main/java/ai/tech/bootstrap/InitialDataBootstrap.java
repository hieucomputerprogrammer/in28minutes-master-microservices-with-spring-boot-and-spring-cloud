package ai.tech.bootstrap;

import ai.tech.domain.Post;
import ai.tech.domain.User;
import ai.tech.repository.PostJpaRepository;
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
public class InitialDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {
  private final UserJpaRepository userRepository;
  private final PostJpaRepository postRepository;

  @Override
  @Transactional
  public void onApplicationEvent(final ContextRefreshedEvent contextRefreshedEvent) {
    this.initializeData();
    log.info("Data initialized.");
  }

  private void initializeData() {
    UUID hieuUUID = UUID.randomUUID();
    User hieu = this.userRepository.save(
        User.builder()
            .uuid(hieuUUID)
            .name("Hieu Minh Le")
            .birthday(Timestamp.valueOf("1994-07-13 00:00:00"))
            .build());
    Post coreJava = this.postRepository.save(
        Post.builder()
            .title("Core Java")
            .summary("Java SE")
            .content("Refer to: https://docs.oracle.com/javase/tutorial/java/")
            .build());
    Post javaEnterpriseEdition = this.postRepository.save(
            Post.builder()
                    .title("Java Enterprise Edition")
                    .summary("Java EE")
                    .content("Refer to: https://www.oracle.com/java/technologies/java-ee-glance.html")
                    .build()
    );
    Post android = this.postRepository.save(
            Post.builder()
                    .title("Android")
                    .summary("Android - Formerly known as Java Mobile Edition (Java ME)")
                    .content("Refer to: https://www.android.com/")
                    .build()
    );
    coreJava.setUser(hieu);
    javaEnterpriseEdition.setUser(hieu);
    android.setUser(hieu);

    UUID jamesGoslingUUID = UUID.randomUUID();
    User jamesGosling = this.userRepository.save(
        User.builder()
            .uuid(jamesGoslingUUID)
            .name("James Gosling")
            .birthday(Timestamp.valueOf("1955-05-19 00:00:00"))
            .build());
    Post javaForEnterprise = this.postRepository.save(
        Post.builder()
            .title("Java for Enterprises")
            .summary("Java EE")
            .content("Refer to: https://www.oracle.com/java/technologies/jee-tutorials.html")
            .build());
    javaForEnterprise.setUser(jamesGosling);

    UUID guidoVanRossumUUID = UUID.randomUUID();
    User guidoVanRossum = this.userRepository.save(
        User.builder()
            .uuid(guidoVanRossumUUID)
            .name("Guido Van Rossum")
            .birthday(Timestamp.valueOf("1956-01-31 00:00:00"))
            .build());
    Post springFrameworkForEnterprises = this.postRepository.save(
        Post.builder()
            .title("Spring Framework for Enterprises")
            .summary("Spring Framework")
            .content("Refer to: https://spring.io")
            .build());
    springFrameworkForEnterprises.setUser(guidoVanRossum);

    UUID timBernersLeeUUID = UUID.randomUUID();
    User timBernersLee = this.userRepository.save(
        User.builder()
            .uuid(timBernersLeeUUID)
            .name("Tim Berners-Lee")
            .birthday(Timestamp.valueOf("1955-06-08 00:00:00"))
            .build());
    Post quarkusForEnterprises = this.postRepository.save(
        Post.builder()
            .title("Quarkus for Enterprises")
            .summary("Quarkus")
            .content("Refer to: https://quarkus.io")
            .build());
    quarkusForEnterprises.setUser(timBernersLee);

    UUID vintCerfUUID = UUID.randomUUID();
    User vinCerf = this.userRepository.save(
        User.builder()
            .uuid(vintCerfUUID)
            .name("Vinton Gray \"Vint\" Cerf")
            .birthday(Timestamp.valueOf("1943-06-23 00:00:00"))
            .build());
    Post micronautForEnterprises = this.postRepository.save(
        Post.builder()
            .title("Micronaut for Enterprises")
            .summary("Micronaut Framework")
            .content("Refer to: https://micronaut.io")
            .build());
    micronautForEnterprises.setUser(vinCerf);
  }
}

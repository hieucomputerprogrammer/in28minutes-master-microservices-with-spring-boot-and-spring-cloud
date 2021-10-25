package ai.tech.web.api.rest;

import ai.tech.domain.User;
import ai.tech.service.UserService;
import ai.tech.web.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserResource {
  private final UserService userService;

  @PostMapping
  public ResponseEntity<URI> add(final @Valid @RequestBody User user) {
    final User savedUser = userService.save(user);
    final URI locationUri =
        ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("api/users/{uuid}")
            .buildAndExpand(savedUser.getUuid())
            .toUri();

    return ResponseEntity.created(locationUri).build();
  }

  @GetMapping
  public ResponseEntity<List<User>> getAll() {
    return ResponseEntity.ok(userService.findAll());
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<EntityModel<User>> getById(final @PathVariable("uuid") UUID uuid) {
    final User foundUser = userService.findById(uuid);
    if (foundUser == null)
      throw new UserNotFoundException("User with UUID: " + uuid + " is not found.");

    EntityModel foundUserEntityModel = EntityModel.of(foundUser);
    WebMvcLinkBuilder linkToUsers =
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAll());
    foundUserEntityModel.add(linkToUsers.withRel("all-users"));

    return ResponseEntity.ok(foundUserEntityModel);
  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<Void> deleteById(final @PathVariable("uuid") UUID uuid) {
    if (userService.findById(uuid) == null)
      throw new UserNotFoundException("User with UUID: " + uuid + " does not exist.");

    userService.deleteById(uuid);
    return ResponseEntity.noContent().build();
  }
}

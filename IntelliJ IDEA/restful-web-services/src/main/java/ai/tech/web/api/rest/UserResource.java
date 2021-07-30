package ai.tech.web.api.rest;

import ai.tech.domain.User;
import ai.tech.service.UserService;
import ai.tech.web.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserResource {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody User user) {
        User savedUser = userService.save(user);
        URI locationUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/users/{uuid}")
                .buildAndExpand(savedUser.getUuid())
                .toUri();

        return ResponseEntity.created(locationUri).build();
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> getById(@PathVariable("uuid") UUID uuid) {
        User foundUser = userService.findById(uuid);
        if (foundUser == null)
            throw new UserNotFoundException("User with UUID: " + uuid + " is not found.");

        return new ResponseEntity<User>(foundUser, HttpStatus.FOUND);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> deleteById(@PathVariable("uuid") UUID uuid) {
        if (userService.findById(uuid) == null)
            throw new UserNotFoundException("User with UUID: " + uuid + " does not exist.");

        userService.deleteById(uuid);
        return ResponseEntity.noContent().build();
    }
}
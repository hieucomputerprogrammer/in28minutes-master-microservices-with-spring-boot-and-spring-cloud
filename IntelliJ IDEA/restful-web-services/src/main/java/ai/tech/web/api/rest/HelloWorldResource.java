package ai.tech.web.api.rest;

import ai.tech.domain.CoffeeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api/hello-world")
public class HelloWorldResource {
  @GetMapping
  public String helloWorld() {
    return "Hello, Spring! :D";
  }

  @GetMapping("java")
  public CoffeeBean coffeeBean() {
    return new CoffeeBean(UUID.randomUUID(), "Java", "Brown", new BigDecimal("5.0"));
  }

  @GetMapping("/{name}")
  public String sayHello(@PathVariable("name") String name) {
    return "Hello, " + name + "! :D";
  }
}

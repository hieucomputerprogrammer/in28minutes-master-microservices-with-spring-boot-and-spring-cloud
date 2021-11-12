package ai.tech.web.api.rest;

import ai.tech.domain.CoffeeBean;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/hello-world")
public class HelloWorldResource {
  private final MessageSource messageSource;

  @GetMapping
  public String helloWorld() {
    return "Hello, Spring! :D";
  }

  @GetMapping("/java")
  public CoffeeBean coffeeBean() {
    return new CoffeeBean(UUID.randomUUID(), "Java", "Brown", new BigDecimal("5.0"));
  }

  @GetMapping("/{name}")
  public String sayHello(final @PathVariable("name") String name) {
    return "Hello, " + name + "! :D";
  }

  /* Using HTTP headers to configure i18n */
//  @GetMapping("/international")
//  public String helloWorldInternational(final @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
//    return this.messageSource.getMessage("good.morning.message", null, "Hello, world!", locale);
//  }

  /* Using LocaleContextHolder to configure i18n */
  @GetMapping("/international")
  public String helloWorldInternational() {
    return this.messageSource.getMessage(
      "good.morning.message", null, "Hello, world!", LocaleContextHolder.getLocale());
  }
}

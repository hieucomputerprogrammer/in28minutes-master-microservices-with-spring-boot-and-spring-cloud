package ai.tech.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hello-world")
public class HelloWorldController {
  @GetMapping
  @ResponseBody
  public String helloWorld() {
    return "Hello, Spring! :D";
  }
}

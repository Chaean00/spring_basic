package spring.spring_basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContrioller {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}

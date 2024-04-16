package springboot.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class LandingPageController {
    
    @GetMapping("/")
    public String landingPage() {
        return "Hello, LandingPage!";
    }
}
    

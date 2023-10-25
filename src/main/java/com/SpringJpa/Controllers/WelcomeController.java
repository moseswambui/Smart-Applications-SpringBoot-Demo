package com.SpringJpa.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Value("${spring.application.name}")
    private String name;
    @GetMapping("/")
    public String welcome() {
        return "Welcome to Spring Data JPA: "+name;
    }
    
}

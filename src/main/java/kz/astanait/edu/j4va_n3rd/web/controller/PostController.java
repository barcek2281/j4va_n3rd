package kz.astanait.edu.j4va_n3rd.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @GetMapping("/")
    public String index() {
        return "Hello, world!";
    }
}

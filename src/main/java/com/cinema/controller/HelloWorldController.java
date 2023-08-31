package com.cinema.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world controller.
 */
@RestController
public class HelloWorldController {

    /**
     * Endpoint to verify if server is running.
     * @return String "Hello World"
     */
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}

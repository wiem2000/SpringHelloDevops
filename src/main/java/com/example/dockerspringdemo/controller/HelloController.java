package com.example.dockerspringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String bonjour() {
        return "Hello Im an App";
    }
    
    @GetMapping("/hello")
    public String gretting() {
        return "Hello";
    }
}
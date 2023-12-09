package com.hungh2002.library.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {
    @GetMapping("")
    public String HelloWorld() {
        return "Hello World";
    }
    
}
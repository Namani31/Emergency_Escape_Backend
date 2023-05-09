package com.namani.demo.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

    @GetMapping("/test")
    public String time() {
        return "Hello, this current server time is " + new Date();
    }
}
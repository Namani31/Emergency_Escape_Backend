package com.namani.demo.controller.swagger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

    @GetMapping("/test/api/swagger1")
    public String swagger1() {
        return "hello12345";
    }

    @GetMapping("/test/api/swagger2")
    public String swagger2(@RequestParam String param) {
        return param;
    }
}

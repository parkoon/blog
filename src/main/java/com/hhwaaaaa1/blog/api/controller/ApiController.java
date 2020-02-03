package com.hhwaaaaa1.blog.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ApiController {
    @GetMapping(value = "/test")
    public String test() {
        System.out.println("api here ? 왔니 ?");
        return "api test !";
    }

    @GetMapping(value = "/test2")
    public String test2() {
        return "api test2 !";
    }
}

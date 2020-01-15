package com.hhwaaaaa1.blog.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @GetMapping(value = "/test")
    public String test() {
        System.out.println("hello here ? 왔니 ?");
        return "hello test !";

    }

    @GetMapping(value = "/test2")
    public String test2() {
        return "hello test2 !";
    }
}

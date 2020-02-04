package com.hhwaaaaa1.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
    @RequestMapping(value = "/")
    public String welcome() {
        return "index";
    }

    @RequestMapping(value = "/{path:[^\\.]*}/{id:[^\\.]*}")
    public String redirect() {
        return "forward:/";
    }
}

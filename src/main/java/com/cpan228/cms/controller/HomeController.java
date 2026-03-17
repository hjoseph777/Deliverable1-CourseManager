package com.cpan228.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/info1")
    public String info1() {
        return "info1";
    }

    @GetMapping("/info2")
    public String info2() {
        return "info2";
    }
}

package com.example.best_of_the_year.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class controller {
    @RequestMapping("/")
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Paolo Fabris");
        return "index";
    }
}

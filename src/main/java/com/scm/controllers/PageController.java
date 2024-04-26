package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {
    
    @GetMapping("/home")
    public String home(Model model) {
        System.out.println("Home Page Handler");
        // Sending data to view
        model.addAttribute("name", "Shoaib Rehman");
        model.addAttribute("instaChannel", "@shoaib.io");
        model.addAttribute("githubRepo", "https://github.com/kryptos-code");
        return new String("Home");
    }
    
}

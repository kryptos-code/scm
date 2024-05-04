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

    // about route
    @GetMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("isLogin", false);
        System.out.println("About page loading");
        // Sending data to view
        return new String("about");
    }

    // services
    @GetMapping("/services")
    public String servicesPage() {
        System.out.println("Services page loading");
        // Sending data to view
        return new String("services");
    }
    
}

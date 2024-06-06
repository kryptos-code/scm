package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.services.UserService;



@Controller
public class PageController {

    @Autowired
    private UserService userService;
    
    // Home
    @GetMapping("/home")
    public String home(Model model) {
        System.out.println("Home Page Handler");
        // Sending data to view
        model.addAttribute("name", "Shoaib Rehman");
        model.addAttribute("instaChannel", "@shoaib.io");
        model.addAttribute("githubRepo", "https://github.com/kryptos-code");
        return new String("Home");
    }

    // About
    @GetMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("isLogin", false);
        System.out.println("About page loading");
        // Sending data to view
        return new String("about");
    }

    // Services
    @GetMapping("/services")
    public String servicesPage() {
        System.out.println("Services page loading");
        // Sending data to view
        return new String("services");
    }

    // Contact
    @GetMapping("/contact")
    public String contactPage(Model model) {
        model.addAttribute("isLogin", false);
        System.out.println("Contact page loading");
        // Sending data to view
        return new String("contact");
    }

    // Login
    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("isLogin", false);
        System.out.println("Login page loading");
        // Sending data to view
        return new String("login");
    }

    // Sign-up
    @GetMapping("/signup")
    public String signupPage(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("isLogin", false);
        model.addAttribute("userForm", userForm);
        System.out.println("Sign up page loading");
        // Sending data to view
        return new String("signup");
    }

    /*
     * Author: Shoaib Rehman
     * Usage: New user registration request handler
     */
    @RequestMapping(value = "/do-register", method=RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm) {
        System.out.println("Registration Processed");
        System.out.println(userForm);

        // fetch form data
        // validate form data
        // save data into DB
        User user = User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())                
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        .phoneNumber(userForm.getPhoneNumber())
        .profilePic("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.Ze_F6AGBDQyYrlbNF7tCXAHaHa%26pid%3DApi&f=1&ipt=1c077992604ea8e204c7f1f0558af567747a08d2c7b7920189e7f9f8136ce354&ipo=images")
        .build();

        User savedUser = userService.saveUser(user);

        // message = "Registration Successful"
        // Redirect to loginpage if successful else signup page

        return new String("redirect:/signup");
    }
    
}

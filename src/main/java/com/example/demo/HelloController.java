package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    // Load home page
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // Handle form submission
    @PostMapping("/greet")
    public String greet(@RequestParam("name") String name, Model model) {

        if ("admin".equals(name)) {
            return "redirect:/success";
        } else {
            model.addAttribute("error", "Invalid User");
            return "home";
        }
    }

    // Success page
    @GetMapping("/success")
    public String success() {
        return "success";
    }

    // Optional: handle /login URL to avoid 404
    @GetMapping("/login")
    public String login() {
        return "home";
    }
}
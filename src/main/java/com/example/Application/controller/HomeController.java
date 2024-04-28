package com.example.Application.controller;

import com.example.Application.servises.AdminService;
import com.example.Application.servises.HomeService;
import com.example.Application.servises.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final HomeService homeService;
    private final UserService userService;
    private final AdminService adminService;

    public HomeController(HomeService homeService, UserService userService, AdminService adminService) {
        this.homeService = homeService;
        this.userService = userService;
        this.adminService = adminService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("text", homeService.getText());
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/public-data")
    public String user(Model model) {
        model.addAttribute("text", userService.getText());
        return "public-data";
    }

    @GetMapping("/private-data")
    public String admin(Model model) {
        model.addAttribute("text", adminService.getText());
        return "private-data";
    }
}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String doLogin(){
        return "loginPage";
    }

    @GetMapping("/logoutSuccessful")
    public String logoutSuccessful(Model model) {

        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }


}
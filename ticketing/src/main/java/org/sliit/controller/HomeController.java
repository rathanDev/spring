package org.sliit.controller;

import org.sliit.model.Greeting;
import org.sliit.model.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String welcome(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "index";
    }

    @GetMapping("/dashboard")
    public String login(Model model) {
        return "dashboard";
    }

}

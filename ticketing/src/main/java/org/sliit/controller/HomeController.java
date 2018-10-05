package org.sliit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String login(Model model) {
        System.out.println("login");
        model.addAttribute("name", "user");
        return "greeting";
    }

}

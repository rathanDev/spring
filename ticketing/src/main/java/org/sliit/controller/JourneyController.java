package org.sliit.controller;

import org.sliit.model.LoginForm;
import org.sliit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/journey")
public class JourneyController {

    @Autowired
    UserService userService;

    @GetMapping("/start")
    public String greetingSubmit() {
        return "journey";
    }

}

package org.sliit.controller;

import org.sliit.model.Greeting;
import org.sliit.model.LoginForm;
import org.sliit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String greetingSubmit(@ModelAttribute LoginForm loginForm) {
        String login = userService.login(loginForm);
        System.out.println("login = " + login);
        return "result";
    }

}

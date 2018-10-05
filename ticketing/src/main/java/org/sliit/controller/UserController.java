package org.sliit.controller;

import org.sliit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        String s = userService.create();
        System.out.println("s = " + s);
        return "user";
    }

}

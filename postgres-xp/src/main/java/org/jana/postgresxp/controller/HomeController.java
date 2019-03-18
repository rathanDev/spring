package org.jana.postgresxp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/get-one")
    public String getOne() {
        return "get-one";
    }

}

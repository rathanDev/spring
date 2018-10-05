package org.sliit.service;

import org.sliit.model.LoginForm;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String login(LoginForm loginForm) {
        return "login";
    }

}

package org.sliit.service;

import org.sliit.model.LoginForm;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean login(LoginForm loginForm) {
        return loginForm.getUsername().equals("user") && loginForm.getPassword().equals("password");
    }

}

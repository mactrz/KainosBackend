package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.User;
import com.kainos.ea.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(path = "/verify")
    public @ResponseBody
    Boolean verifyUser(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        return userService.validateUser(user) && userService.doCredentialsMatch(username, password, passwordEncoder);
    }
}

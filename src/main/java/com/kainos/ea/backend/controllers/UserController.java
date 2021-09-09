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
    User verifyUser(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        if(userService.validateUserData(username, password)) {
            User userData = userService.authenticateUser(username, password, passwordEncoder);
            try {
                userData.setPassword(null);
            }
            catch (NullPointerException e) {
                return userData;
            }
            return userData;
        }
        return null;
    }
}

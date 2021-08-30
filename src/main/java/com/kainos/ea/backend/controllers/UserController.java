package com.kainos.ea.backend.controllers;


import com.kainos.ea.backend.models.User;
import com.kainos.ea.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/verify")
    public @ResponseBody
    Boolean verifyUser(@RequestBody User user) {
        //If any accounts match username and password return true
        String username = user.getUsername();
        String password = user.getPassword();
        List<User> users = userService.getUsers();
        return users.stream()
                .anyMatch(user1 -> {
                    System.out.println(("Usernames: " + user1.getUsername()).equals(username));
                    System.out.println("Pass sent:"+password);
                    System.out.println("Pass: "+ passwordEncoder.matches(password, user1.getPassword()));
                     return (user1.getUsername().equals(username))
                        && (passwordEncoder.matches(password, user1.getPassword()));
                });
    }


    // Creating a user for future implementation

//    @PostMapping(path = "/create")
//    public @ResponseBody
//    User createUser(@RequestBody User user) {
//        // Set password to be encrypted
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userService.saveUser(user);
//    }
}

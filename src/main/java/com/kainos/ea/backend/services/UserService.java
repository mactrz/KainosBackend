package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.User;
import com.kainos.ea.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Boolean validatePassword(String password) {
        Pattern regexp = Pattern.compile("^(?=.*?[a-z]).{8,}$");
        Matcher matcher = regexp.matcher(password);
        return matcher.find();
    }

    public Boolean validateUsername(String username) {
        Pattern regexp = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*");
        Matcher matcher = regexp.matcher(username);
        return matcher.find();
    }

    public Boolean validateUser(User user) {
        return validateUsername(user.getUsername())
        && validatePassword(user.getPassword());
    }

}

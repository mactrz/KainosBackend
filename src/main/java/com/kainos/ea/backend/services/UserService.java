package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.User;
import com.kainos.ea.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
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

    public Boolean validateUserData(String username, String password) {
        return validateUsername(username)
        && validatePassword(password);
    }

    public User authenticateUser(String username, String password, BCryptPasswordEncoder passwordEncoder) {
        Optional<User> user = getUserByUsername(username);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return user.get();
        }
        return null;
    }
}

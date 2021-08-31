package com.kainos.ea.backend.controllers;

import com.kainos.ea.backend.models.User;
import com.kainos.ea.backend.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void when_verifyUser_called_with_valid_user_expect_true() {
        User validUser = new User("mail@email.com", "strong_password");
        List<User> users = List.of(new User("mail@email.com", "strong_password"));
        Mockito.when(userService.validateUser(validUser)).thenReturn(true);
        Mockito.when(userService.getUsers()).thenReturn(users);
        Mockito.when(passwordEncoder.matches("strong_password", "strong_password")).thenReturn(true);
        UserController userController = new UserController(userService, passwordEncoder);

        Boolean results = userController.verifyUser(validUser);
        Mockito.verify(userService).validateUser(validUser);
        Mockito.verify(userService).getUsers();

        assertTrue(results);
    }

    @Test
    public void when_verifyUser_called_with_unknown_user_expect_false() {
        User invalidUser = new User("mail@email.com", "strong_password");
        List<User> users = List.of(new User("new@email.com", "strong_password"));
        Mockito.when(userService.validateUser(invalidUser)).thenReturn(true);
        Mockito.when(userService.getUsers()).thenReturn(users);
        UserController userController = new UserController(userService, passwordEncoder);

        Boolean results = userController.verifyUser(invalidUser);
        Mockito.verify(userService).validateUser(invalidUser);
        Mockito.verify(userService).getUsers();

        assertFalse(results);
    }

    @Test
    public void when_verifyUser_called_with_user_invalid_email_expect_false() {
        User invalidUser = new User("mailemail.com", "strong_password");
        Mockito.when(userService.validateUser(invalidUser)).thenReturn(false);
        UserController userController = new UserController(userService);

        Boolean results = userController.verifyUser(invalidUser);
        Mockito.verify(userService).validateUser(invalidUser);

        assertFalse(results);
    }

    @Test
    public void when_verifyUser_called_with_user_empty_mail_expect_false() {
        User invalidUser = new User("", "strong_password");
        Mockito.when(userService.validateUser(invalidUser)).thenReturn(false);
        UserController userController = new UserController(userService);

        Boolean results = userController.verifyUser(invalidUser);
        Mockito.verify(userService).validateUser(invalidUser);

        assertFalse(results);
    }

    @Test
    public void when_verifyUser_called_with_user_empty_password_expect_false() {
        User invalidUser = new User("mail@kainos.com", "");
        Mockito.when(userService.validateUser(invalidUser)).thenReturn(false);
        UserController userController = new UserController(userService);

        Boolean results = userController.verifyUser(invalidUser);
        Mockito.verify(userService).validateUser(invalidUser);

        assertFalse(results);
    }

    @Test
    public void when_verifyUser_called_with_good_username_bad_password_expect_false() {
        User invalidUser = new User("mail@email.com", "strong_pas");
        List<User> users = List.of(new User("mail@email.com", "strong_password"));
        Mockito.when(userService.validateUser(invalidUser)).thenReturn(true);
        Mockito.when(userService.getUsers()).thenReturn(users);
        Mockito.when(passwordEncoder.matches("strong_pas", "strong_password")).thenReturn(false);
        UserController userController = new UserController(userService, passwordEncoder);

        Boolean results = userController.verifyUser(invalidUser);
        Mockito.verify(userService).validateUser(invalidUser);
        Mockito.verify(userService).getUsers();

        assertFalse(results);
    }

    @Test
    public void when_verifyUser_called_with_good_password_bad_username_expect_false() {
        User invalidUser = new User("ma@email.com", "strong_password");
        List<User> users = List.of(new User("mail@email.com", "strong_password"));
        Mockito.when(userService.validateUser(invalidUser)).thenReturn(true);
        Mockito.when(userService.getUsers()).thenReturn(users);
        UserController userController = new UserController(userService, passwordEncoder);


        Boolean results = userController.verifyUser(invalidUser);
        Mockito.verify(userService).validateUser(invalidUser);
        Mockito.verify(userService).getUsers();

        assertFalse(results);
    }
}

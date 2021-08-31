package com.kainos.ea.backend.controllers;
import com.kainos.ea.backend.models.User;
import com.kainos.ea.backend.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;
    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void when_verifyUserCalledWithValidUser_expect_true() {
        User validUser = new User("mail@email.com", "strong_password");
        Mockito.when(userService.validateUser(validUser)).thenReturn(true);
        Mockito.when(userService.doCredentialsMatch("mail@email.com", "strong_password", passwordEncoder)).thenReturn(true);
        UserController userController = new UserController(userService, passwordEncoder);
        Boolean results = userController.verifyUser(validUser);
        Mockito.verify(userService).validateUser(validUser);
        assertTrue(results);
    }
    @Test
    public void when_verifyUserCalledWithUnknownUser_expect_false() {
        User invalidUser = new User("mail@email.com", "strong_password");
        Mockito.when(userService.validateUser(invalidUser)).thenReturn(true);
        Mockito.when(userService.doCredentialsMatch("mail@email.com", "strong_password", passwordEncoder)).thenReturn(false);
        UserController userController = new UserController(userService, passwordEncoder);
        Boolean results = userController.verifyUser(invalidUser);
        Mockito.verify(userService).validateUser(invalidUser);
        assertFalse(results);
    }
    @Test
    public void when_verifyUserCalledWithUserInvalidEmail_expect_false() {
        User invalidUser = new User("mailemail.com", "strong_password");
        Mockito.when(userService.validateUser(invalidUser)).thenReturn(false);
        UserController userController = new UserController(userService);
        Boolean results = userController.verifyUser(invalidUser);
        Mockito.verify(userService).validateUser(invalidUser);
        assertFalse(results);
    }
    @Test
    public void when_verifyUserCalledWithUserEmptyMail_expect_false() {
        User invalidUser = new User("", "strong_password");
        Mockito.when(userService.validateUser(invalidUser)).thenReturn(false);
        UserController userController = new UserController(userService);
        Boolean results = userController.verifyUser(invalidUser);
        Mockito.verify(userService).validateUser(invalidUser);
        assertFalse(results);
    }
    @Test
    public void when_verifyUserCalledWithUserEmptyPassword_expect_false() {
        User invalidUser = new User("mail@kainos.com", "");
        Mockito.when(userService.validateUser(invalidUser)).thenReturn(false);
        UserController userController = new UserController(userService);
        Boolean results = userController.verifyUser(invalidUser);
        Mockito.verify(userService).validateUser(invalidUser);
        assertFalse(results);
    }

    @Test
    public void when_verifyUserCalledWithGoodUsernameBadPassword_expect_false() {
        User invalidUser = new User("mail@email.com", "strong_pas");
        Mockito.when(userService.validateUser(invalidUser)).thenReturn(true);
        Mockito.when(userService.doCredentialsMatch("mail@email.com", "strong_pas", passwordEncoder)).thenReturn(false);
        UserController userController = new UserController(userService, passwordEncoder);
        Boolean results = userController.verifyUser(invalidUser);
        Mockito.verify(userService).validateUser(invalidUser);
        assertFalse(results);
    }

    @Test
    public void when_verifyUserCalledWithGoodPasswordBadUsername_expect_false() {
        User invalidUser = new User("ma@email.com", "strong_password");
        Mockito.when(userService.validateUser(invalidUser)).thenReturn(true);
        Mockito.when(userService.doCredentialsMatch("ma@email.com", "strong_password", passwordEncoder)).thenReturn(false);
        UserController userController = new UserController(userService, passwordEncoder);
        Boolean results = userController.verifyUser(invalidUser);
        Mockito.verify(userService).validateUser(invalidUser);
        assertFalse(results);
    }
}

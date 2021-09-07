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
    public void when_verifyUserCalledWithValidUser_expect_ResultsNotNull() {
        User validUser = new User("mail@email.com", "strong_password");
        Mockito.when(userService.validateUserData(validUser.getUsername(), validUser.getPassword())).thenReturn(true);
        Mockito.when(userService.authenticateUser("mail@email.com", "strong_password", passwordEncoder)).thenReturn(new User());
        UserController userController = new UserController(userService, passwordEncoder);

        User result = userController.verifyUser(validUser);

        Mockito.verify(userService).validateUserData(validUser.getUsername(), validUser.getPassword());
        assertNotNull(result);
    }

    @Test
    public void when_verifyUserCalledWithUnknownUser_expect_ResultToBeNull() {
        User invalidUser = new User("mail@email.com", "strong_password");
        Mockito.when(userService.validateUserData(invalidUser.getUsername(), invalidUser.getPassword())).thenReturn(true);
        Mockito.when(userService.authenticateUser("mail@email.com", "strong_password", passwordEncoder)).thenReturn(null);
        UserController userController = new UserController(userService, passwordEncoder);

        User result = userController.verifyUser(invalidUser);

        Mockito.verify(userService).validateUserData(invalidUser.getUsername(), invalidUser.getPassword());
        assertNull(result);
    }

    @Test
    public void when_verifyUserCalledWithUserInvalidEmail_expect_ResultToBeNull() {
        User invalidUser = new User("mailemail.com", "strong_password");
        Mockito.when(userService.validateUserData(invalidUser.getUsername(), invalidUser.getPassword())).thenReturn(false);
        UserController userController = new UserController(userService);

        User result = userController.verifyUser(invalidUser);

        Mockito.verify(userService).validateUserData(invalidUser.getUsername(), invalidUser.getPassword());
        assertNull(result);
    }

    @Test
    public void when_verifyUserCalledWithUserEmptyMail_expect_ResultToBeNull() {
        User invalidUser = new User("", "strong_password");
        Mockito.when(userService.validateUserData(invalidUser.getUsername(), invalidUser.getPassword())).thenReturn(false);
        UserController userController = new UserController(userService);

        User result = userController.verifyUser(invalidUser);

        Mockito.verify(userService).validateUserData(invalidUser.getUsername(), invalidUser.getPassword());
        assertNull(result);
    }

    @Test
    public void when_verifyUserCalledWithUserEmptyPassword_expect_ResultToBeNull() {
        User invalidUser = new User("mail@kainos.com", "");
        Mockito.when(userService.validateUserData(invalidUser.getUsername(), invalidUser.getPassword())).thenReturn(false);
        UserController userController = new UserController(userService);

        User result = userController.verifyUser(invalidUser);

        Mockito.verify(userService).validateUserData(invalidUser.getUsername(), invalidUser.getPassword());
        assertNull(result);
    }

    @Test
    public void when_verifyUserCalledWithGoodUsernameBadPassword_expect_ResultToBeNull() {
        User invalidUser = new User("mail@email.com", "strong_pas");
        Mockito.when(userService.validateUserData(invalidUser.getUsername(), invalidUser.getPassword())).thenReturn(true);
        Mockito.when(userService.authenticateUser("mail@email.com", "strong_pas", passwordEncoder)).thenReturn(null);
        UserController userController = new UserController(userService, passwordEncoder);

        User result = userController.verifyUser(invalidUser);

        Mockito.verify(userService).validateUserData(invalidUser.getUsername(), invalidUser.getPassword());
        assertNull(result);
    }

    @Test
    public void when_verifyUserCalledWithGoodPasswordBadUsername_expect_false() {
        User invalidUser = new User("ma@email.com", "strong_password");
        Mockito.when(userService.validateUserData(invalidUser.getUsername(), invalidUser.getPassword())).thenReturn(true);
        Mockito.when(userService.authenticateUser("ma@email.com", "strong_password", passwordEncoder)).thenReturn(null);
        UserController userController = new UserController(userService, passwordEncoder);

        User results = userController.verifyUser(invalidUser);

        Mockito.verify(userService).validateUserData(invalidUser.getUsername(), invalidUser.getPassword());
        assertNull(results);
    }
}

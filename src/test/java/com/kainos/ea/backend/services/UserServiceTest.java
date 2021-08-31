package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.User;
import com.kainos.ea.backend.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    public void when_getUsersCalled_expect_listOfUsers() {
        List<User> users = List.of(
                new User("mail@email.com", "strong_password"),
                new User("mail2@kainos.com", "weak_password"));

        Mockito.when(userRepository.findAll()).thenReturn(users);
        UserService userService = new UserService(userRepository);

        List<User> result = userService.getUsers();
        Mockito.verify(userRepository).findAll();

        assertEquals(users, result);
    }

    @Test
    public void when_validatePasswordCalledWithValidPassword_expect_true() {
        UserService userService = new UserService(userRepository);
        Boolean result = userService.validatePassword("strong_password");

        assertTrue(result);
    }

    @Test
    public void when_validatePasswordCalledWithTooShortPassword_expect_false() {
        UserService userService = new UserService(userRepository);
        Boolean result = userService.validatePassword("asd");

        assertFalse(result);
    }

    @Test
    public void when_validatePasswordCalledWithNoLettersPassword_expect_false() {
        UserService userService = new UserService(userRepository);
        Boolean result = userService.validatePassword("123");

        assertFalse(result);
    }

    @Test
    public void when_validatePasswordCalledWithEmptyPassword_expect_false() {
        UserService userService = new UserService(userRepository);
        Boolean result = userService.validatePassword("123");

        assertFalse(result);
    }

    @Test
    public void when_validateUsernameCalledWithValidUsername_expect_true() {
        UserService userService = new UserService(userRepository);
        Boolean result = userService.validateUsername("mail@kainos.com");

        assertTrue(result);
    }

    @Test
    public void when_validateUsernameCalledWithNoAt_expect_false() {
        UserService userService = new UserService(userRepository);
        Boolean result = userService.validateUsername("mailkainos.com");

        assertFalse(result);
    }

    @Test
    public void when_validateUsernameCalledWithNoDomain_expect_false() {
        UserService userService = new UserService(userRepository);
        Boolean result = userService.validateUsername("mail@.com");

        assertFalse(result);
    }

    @Test
    public void when_validateUsernameCalledWithNoName_expect_false() {
        UserService userService = new UserService(userRepository);
        Boolean result = userService.validateUsername("@kainos.com");

        assertFalse(result);
    }

    @Test
    public void when_validateUserCalledWithValidUser_expect_true() {
        User validUser = new User("mail@kainos.com", "strong_password");

        UserService userService = new UserService(userRepository);
        Boolean result = userService.validateUser(validUser);

        assertTrue(result);
    }

    @Test
    public void when_validateUserCalledWithInvalidUser_expect_false() {
        User validUser = new User("", "");

        UserService userService = new UserService(userRepository);
        Boolean result = userService.validateUser(validUser);

        assertFalse(result);
    }
}

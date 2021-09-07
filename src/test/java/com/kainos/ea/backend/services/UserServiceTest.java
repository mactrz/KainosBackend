package com.kainos.ea.backend.services;

import com.kainos.ea.backend.models.User;
import com.kainos.ea.backend.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private BCryptPasswordEncoder passwordEncoder;
    private UserService userService;
    private List<User> users;

    @BeforeEach
    public void setUp() {
        userService = new UserService(userRepository);
        users = List.of(
                new User("mail@email.com", "strong_password"),
                new User("mail2@kainos.com", "weak_password"));
    }

    @Test
    public void when_CallingGetUsers_expect_listOfUsers() {
        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getUsers();

        Mockito.verify(userRepository).findAll();
        assertEquals(users, result);
    }

    @Test
    public void when_CallingValidatePasswordWithValidPassword_expect_true() {
        Boolean result = userService.validatePassword("strong_password");

        assertTrue(result);
    }

    @Test
    public void when_CallingValidatePasswordWithTooShortPassword_expect_false() {
        Boolean result = userService.validatePassword("asd");

        assertFalse(result);
    }

    @Test
    public void when_CallingValidatePasswordWithNoLettersPassword_expect_false() {
        Boolean result = userService.validatePassword("123");

        assertFalse(result);
    }

    @Test
    public void when_CallingValidatePasswordWithEmptyPassword_expect_false() {
        Boolean result = userService.validatePassword("123");

        assertFalse(result);
    }

    @Test
    public void when_CallingValidateUsernameWithValidUsername_expect_true() {
        Boolean result = userService.validateUsername("mail@kainos.com");

        assertTrue(result);
    }

    @Test
    public void when_CallingValidateUsernameWithNoAt_expect_false() {
        Boolean result = userService.validateUsername("mailkainos.com");

        assertFalse(result);
    }

    @Test
    public void when_CallingValidateUsernameWithNoDomain_expect_false() {
        Boolean result = userService.validateUsername("mail@.com");

        assertFalse(result);
    }

    @Test
    public void when_CallingValidateUsernameWithNoName_expect_false() {
        Boolean result = userService.validateUsername("@kainos.com");

        assertFalse(result);
    }

    @Test
    public void when_CallingValidateUserWithValidUser_expect_true() {
        User validUser = new User("mail@kainos.com", "strong_password");

        Boolean result = userService.validateUser(validUser);

        assertTrue(result);
    }

    @Test
    public void when_CallingValidateUserWithInvalidUser_expect_false() {
        User validUser = new User("", "");

        Boolean result = userService.validateUser(validUser);

        assertFalse(result);
    }

    @Test
    public void when_CallingDoCredentialMatchWithMatchingCredentials_expect_true() {
        Mockito.when(userRepository.findAll()).thenReturn(users);
        Mockito.when(passwordEncoder.matches("strong_password", "strong_password")).thenReturn(true);

        Boolean result = userService.doCredentialsMatch("mail@email.com", "strong_password", passwordEncoder);

        assertTrue(result);
    }

    @Test
    public void when_CallingDoCredentialMatchWithBadUsername_expect_false() {
        Mockito.when(userRepository.findAll()).thenReturn(users);

        Boolean result = userService.doCredentialsMatch("maillll@email.com", "strong_password", passwordEncoder);

        assertFalse(result);
    }

    @Test
    public void when_CallingDoCredentialMatchWithBadPassword_expect_false() {
        Mockito.when(userRepository.findAll()).thenReturn(users);
        Mockito.when(passwordEncoder.matches("strong_passworddd", "strong_password")).thenReturn(false);

        Boolean result = userService.doCredentialsMatch("mail@email.com", "strong_passworddd", passwordEncoder);

        assertFalse(result);
    }
}

package com.kainos.ea.backend.repositories;

import com.kainos.ea.backend.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
    Optional<User> findByUsername(String username);
}

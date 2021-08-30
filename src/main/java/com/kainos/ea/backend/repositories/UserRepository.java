package com.kainos.ea.backend.repositories;

import com.kainos.ea.backend.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public List<User> findAll();
}

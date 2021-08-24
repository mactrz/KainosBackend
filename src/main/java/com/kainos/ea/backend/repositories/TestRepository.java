package com.kainos.ea.backend.repositories;

import com.kainos.ea.backend.models.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface TestRepository extends CrudRepository<Test, String> {

}

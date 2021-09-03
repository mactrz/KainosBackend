package com.kainos.ea.backend.repositories;

import com.kainos.ea.backend.models.Band;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BandRepository extends CrudRepository<Band, String> {
    List<Band> findAllByOrderByLevelDesc();
}

package com.kainos.ea.backend.repositories;

import com.kainos.ea.backend.models.BandTraining;
import com.kainos.ea.backend.models.BandTrainingID;
import com.kainos.ea.backend.models.Training;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BandTrainingRepository extends CrudRepository<BandTraining, BandTrainingID> {

//    @Query( value = "SELECT bandName, trainingName, trainingType, sharepointURL FROM Training" +
//            " INNER JOIN BandTraining USING(trainingID)", nativeQuery = true)
//    Iterable<BandTraining> getTrainingByBand();

    Iterable<BandTraining> findAll();
}

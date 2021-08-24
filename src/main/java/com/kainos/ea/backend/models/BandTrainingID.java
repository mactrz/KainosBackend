package com.kainos.ea.backend.models;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BandTrainingID implements Serializable {

    private String bandName;
    private short trainingID;

    public BandTrainingID() {}

    public BandTrainingID(String bandName, short trainingID) {
        this.bandName = bandName;
        this.trainingID = trainingID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BandTrainingID that = (BandTrainingID) o;
        return trainingID == that.trainingID && bandName.equals(that.bandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bandName, trainingID);
    }
}

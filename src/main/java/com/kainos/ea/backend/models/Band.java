package com.kainos.ea.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Band")
public class Band {

    @Id
    @Column(name = "bandName")
    private String band;

    /*
     *       CONSTRUCTORS
     * */

    public Band() {}

    /*
     *       OVERRIDDEN METHODS
     * */

    @Override
    public String toString() {
        return "Band{" +
                "band='" + band + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Band band1 = (Band) o;
        return band.equals(band1.band);
    }

    @Override
    public int hashCode() {
        return Objects.hash(band);
    }

    /*
     *       GETTERS AND SETTERS
     * */

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }
}

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
    private String name;

    /*
     *       CONSTRUCTORS
     * */
  
    public Band() {}

    public Band(String bandName) {
        this.name = bandName;
    }

    /*
     *       OVERRIDDEN METHODS
     * */

    @Override
    public String toString() {
        return "Band{" +
                "name='" + name + '\'' +
                '}';

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Band band1 = (Band) o;
        return name.equals(band1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /*
     *       GETTERS AND SETTERS
     * */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

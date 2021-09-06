package com.kainos.ea.backend.models;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Band")
public class Band {

    @Id
    @Column(name = "bandName")
    private String name;

    @Column(name = "level")
    private String level;

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
                ", level='" + level + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Band band = (Band) o;
        return Objects.equals(name, band.name) && Objects.equals(level, band.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level);
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}

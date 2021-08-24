package com.kainos.ea.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "Band")
public class Band {
    @Id
    @Column(name = "bandName")
    private String bandName;

    public Band() {
    }

    public Band(String bandName) {
        this.bandName = bandName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    @Override
    public String toString() {
        return "Band{" +
                "bandName='" + bandName + '\'' +
                '}';
    }
}
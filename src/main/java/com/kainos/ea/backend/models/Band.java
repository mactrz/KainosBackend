package com.kainos.ea.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Band")
public class Band {

    @Id
    @Column(name = "bandName")
    private String name;

    public Band() {}

    public Band(String bandName) {
        this.name = bandName;
    }

    public String getName() {
        return name;
    }

    public void setName(String bandName) {
        this.name = bandName;
    }

    @Override
    public String toString() {
        return "Band{" +
                "name='" + name + '\'' +
                '}';
    }
}

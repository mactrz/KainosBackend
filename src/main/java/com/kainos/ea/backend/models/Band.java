package com.kainos.ea.backend.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Band")
public class Band {
    @Id
    @Column(name = "bandName")
    private String bandName;

    @OneToMany(mappedBy = "band")
    Set<BandCompetency> description;

    public Band() {
    }

    public Band(String bandName) {
        this.bandName = bandName;
    }

    public Set<BandCompetency> getBand() {
        return description;
    }

    public void setBand(Set<BandCompetency> descriptions) {
        this.description = descriptions;
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

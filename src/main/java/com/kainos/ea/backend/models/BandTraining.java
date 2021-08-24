package com.kainos.ea.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "BandTraining")
//@IdClass(BandTrainingID.class)
public class BandTraining {

    @Id
    @Column(name = "bandTrainingID")
    private short id;

    @ManyToOne
    @JoinColumn(name = "bandName")
    private Band band;

    @ManyToOne
    @JoinColumn(name = "trainingID")
    private Training training;

//    @EmbeddedId
//    private BandTrainingID bandTrainingID;

    public BandTraining() {}

    public BandTraining(short id, Band band, Training training) {
        this.id = id;
        this.band = band;
        this.training = training;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    @Override
    public String toString() {
        return "BandTraining{" +
                "id=" + id +
                ", band=" + band +
                ", training=" + training +
                '}';
    }
}

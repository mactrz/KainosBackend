package com.kainos.ea.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "BandTraining")
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

    @Column(name = "recommended")
    private boolean recommended;

    public BandTraining() {}

    public BandTraining(short id, Band band, Training training, boolean recommended) {
        this.id = id;
        this.band = band;
        this.training = training;
        this.recommended = recommended;
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

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    @Override
    public String toString() {
        return "BandTraining{" +
                "id=" + id +
                ", band=" + band +
                ", training=" + training +
                ", recommended=" + recommended +
                '}';
    }
}

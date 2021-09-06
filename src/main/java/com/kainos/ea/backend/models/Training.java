package com.kainos.ea.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "Training")
public class Training {

    public enum TrainingType {
        DEVELOPMENT_PROGRAMME,
        PROFESSIONAL_SKILLS,
        TECHNICAL_SKILLS
    }

    @Id
    @Column(name = "trainingID")
    private short ID;

    @Column(name = "trainingName")
    private String name;

    @Column(name = "trainingType")
    @Enumerated(EnumType.STRING)
    private TrainingType type;

    @Column(name = "recommended")
    private boolean recommended;

    @Column(name = "sharepointURL")
    private String sharepointURL;

    public Training() {}

    public Training(short trainingID, String trainingName, TrainingType trainingType, boolean recommended, String sharepointURL) {
        this.ID = trainingID;
        this.name = trainingName;
        this.type = trainingType;
        this.recommended = recommended;
        this.sharepointURL = sharepointURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrainingType getType() {
        return type;
    }

    public void setType(TrainingType type) {
        this.type = type;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public String getSharepointURL() {
        return sharepointURL;
    }

    public void setSharepointURL(String sharepointURL) {
        this.sharepointURL = sharepointURL;
    }

    @Override
    public String toString() {
        return "Training{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", recommended=" + recommended +
                ", sharepointURL='" + sharepointURL + '\'' +
                '}';
    }
}

package com.kainos.ea.Backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JobRole")
public class JobRole {
    @Id
    @GeneratedValue
    @Column(name = "jobRole_id")
    private Integer id;


    public JobRole() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                "JobRole [id=%s]", id);
    }
}

package com.kainos.ea.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @Column(name = "test")
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String text) {
        this.test = text;
    }

    public Test() {
    }

    public Test(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Test{" +
                "test='" + test + '\'' +
                '}';
    }
}

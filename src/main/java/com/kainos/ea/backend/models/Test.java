package com.kainos.ea.backend.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {
    @Id
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

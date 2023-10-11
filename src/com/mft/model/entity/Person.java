package com.mft.model.entity;

import com.google.gson.Gson;

public class Person {
    private int id;
    private String name;
    private String family;

    public Person() {
    }
    public Person(int id, String name, String family) {
        this.id = id;
        this.name = name;
        this.family = family;
    }
    public Person(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}



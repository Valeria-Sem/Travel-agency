package com.epam.travelAgency.entity;

import java.util.Objects;

public class MealsEntity {
    private int id;
    private String name;

    public MealsEntity() {
    }

    public MealsEntity(String name) {
        this.name = name;
    }

    public MealsEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealsEntity that = (MealsEntity) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

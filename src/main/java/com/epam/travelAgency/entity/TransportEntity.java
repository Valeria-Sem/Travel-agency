package com.epam.travelAgency.entity;

import java.io.Serializable;
import java.util.Objects;

public class TransportEntity implements Serializable {
    private int id;
    private String name;

    public TransportEntity() {
    }

    public TransportEntity(String name) {
        this.name = name;
    }

    public TransportEntity(int id, String name) {
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
        TransportEntity that = (TransportEntity) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "TransportEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

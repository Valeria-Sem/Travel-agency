package com.epam.travelAgency.entity;

import java.io.Serializable;
import java.util.Objects;

public class HotelEntity implements Serializable {
    private int id;
    private String name;
    private int stars;
    private int coastline;
    private String beach;

    public HotelEntity() {
    }

    public HotelEntity(int id, String name, int stars, int coastline, String beach) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.coastline = coastline;
        this.beach = beach;
    }

    public HotelEntity(String name, int stars, int coastline, String beach) {
        this.name = name;
        this.stars = stars;
        this.coastline = coastline;
        this.beach = beach;
    }

    public HotelEntity(String name, int stars) {
        this.name = name;
        this.stars = stars;
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

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getCoastline() {
        return coastline;
    }

    public void setCoastline(int coastline) {
        this.coastline = coastline;
    }

    public String getBeach() {
        return beach;
    }

    public void setBeach(String beach) {
        this.beach = beach;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelEntity that = (HotelEntity) o;
        return id == that.id &&
                stars == that.stars &&
                coastline == that.coastline &&
                name.equals(that.name) &&
                Objects.equals(beach, that.beach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, stars, coastline, beach);
    }

    @Override
    public String toString() {
        return "HotelEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                ", coastline=" + coastline +
                ", beach='" + beach + '\'' +
                '}';
    }
}

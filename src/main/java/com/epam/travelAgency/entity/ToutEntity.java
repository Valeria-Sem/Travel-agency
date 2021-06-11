package com.epam.travelAgency.entity;

import java.io.Serializable;
import java.util.Objects;

public class ToutEntity implements Serializable {
    private int id;
    private String name;
    private String description;
    private int price;
    private String imgPath;
    private TourStatus status;
    private int adults;
    private int children;
    private int idCategory;
    private int idHotel;
    private int idMeals;
    private int idTransport;

    public ToutEntity() {
    }

    public ToutEntity(int id, String name, String description, int price,
                      String imgPath, TourStatus status, int adults,
                      int children, int idCategory, int idHotel,
                      int idMeals, int idTransport) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgPath = imgPath;
        this.status = status;
        this.adults = adults;
        this.children = children;
        this.idCategory = idCategory;
        this.idHotel = idHotel;
        this.idMeals = idMeals;
        this.idTransport = idTransport;
    }

    public ToutEntity(int id, String name, String description, int price,
                      String imgPath, int adults,
                      int children, int idCategory, int idHotel,
                      int idMeals, int idTransport) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgPath = imgPath;
        this.adults = adults;
        this.children = children;
        this.idCategory = idCategory;
        this.idHotel = idHotel;
        this.idMeals = idMeals;
        this.idTransport = idTransport;
    }

    public ToutEntity(int id, String name, String description,
                      int price, String imgPath, int adults, int idCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgPath = imgPath;
        this.adults = adults;
        this.idCategory = idCategory;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public TourStatus getStatus() {
        return status;
    }

    public void setStatus(TourStatus status) {
        this.status = status;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getIdMeals() {
        return idMeals;
    }

    public void setIdMeals(int idMeals) {
        this.idMeals = idMeals;
    }

    public int getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(int idTransport) {
        this.idTransport = idTransport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToutEntity that = (ToutEntity) o;
        return id == that.id &&
                price == that.price &&
                adults == that.adults &&
                children == that.children &&
                idCategory == that.idCategory &&
                idHotel == that.idHotel &&
                idMeals == that.idMeals &&
                idTransport == that.idTransport &&
                name.equals(that.name) &&
                description.equals(that.description) &&
                imgPath.equals(that.imgPath) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, imgPath, status,
                adults, children, idCategory, idHotel, idMeals, idTransport);
    }
}

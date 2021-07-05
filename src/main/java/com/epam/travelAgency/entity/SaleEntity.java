package com.epam.travelAgency.entity;

import java.io.Serializable;
import java.util.Objects;

public class SaleEntity implements Serializable {
    private int id;
    private int idUserDet;
    private int sale;
    private int toursCount;

    public SaleEntity() {
    }

    public SaleEntity(int idUserDet, int sale, int toursCount) {
        this.idUserDet = idUserDet;
        this.sale = sale;
        this.toursCount = toursCount;
    }

    public SaleEntity(int id, int idUserDet, int sale, int toursCount) {
        this.id = id;
        this.idUserDet = idUserDet;
        this.sale = sale;
        this.toursCount = toursCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUserDet() {
        return idUserDet;
    }

    public void setIdUserDet(int idUserDet) {
        this.idUserDet = idUserDet;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getToursCount() {
        return toursCount;
    }

    public void setToursCount(int toursCount) {
        this.toursCount = toursCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleEntity that = (SaleEntity) o;
        return id == that.id && idUserDet == that.idUserDet && sale == that.sale && toursCount == that.toursCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUserDet, sale, toursCount);
    }
}

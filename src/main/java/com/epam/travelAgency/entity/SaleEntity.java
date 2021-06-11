package com.epam.travelAgency.entity;

import java.io.Serializable;
import java.util.Objects;

public class SaleEntity implements Serializable {
    private int id;
    private int idUserDet;
    private int sale;

    public SaleEntity() {
    }

    public SaleEntity(int idUserDet, int sale) {
        this.idUserDet = idUserDet;
        this.sale = sale;
    }

    public SaleEntity(int id, int idUserDet, int sale) {
        this.id = id;
        this.idUserDet = idUserDet;
        this.sale = sale;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleEntity that = (SaleEntity) o;
        return id == that.id && idUserDet == that.idUserDet && sale == that.sale;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUserDet, sale);
    }
}

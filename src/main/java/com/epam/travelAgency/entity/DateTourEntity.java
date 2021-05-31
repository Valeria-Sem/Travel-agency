package com.epam.travelAgency.entity;

import java.util.Objects;

public class DateTourEntity {
    private int id;
    private int idArrivalDate;
    private int idDepartureDate;
    private int idTour;

    public DateTourEntity() {
    }

    public DateTourEntity(int id, int idArrivalDate, int idDepartureDate, int idTour) {
        this.id = id;
        this.idArrivalDate = idArrivalDate;
        this.idDepartureDate = idDepartureDate;
        this.idTour = idTour;
    }

    public DateTourEntity(int idArrivalDate, int idDepartureDate, int idTour) {
        this.idArrivalDate = idArrivalDate;
        this.idDepartureDate = idDepartureDate;
        this.idTour = idTour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdArrivalDate() {
        return idArrivalDate;
    }

    public void setIdArrivalDate(int idArrivalDate) {
        this.idArrivalDate = idArrivalDate;
    }

    public int getIdDepartureDate() {
        return idDepartureDate;
    }

    public void setIdDepartureDate(int idDepartureDate) {
        this.idDepartureDate = idDepartureDate;
    }

    public int getIdTour() {
        return idTour;
    }

    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTourEntity that = (DateTourEntity) o;
        return id == that.id && idArrivalDate == that.idArrivalDate && idDepartureDate == that.idDepartureDate && idTour == that.idTour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idArrivalDate, idDepartureDate, idTour);
    }
}

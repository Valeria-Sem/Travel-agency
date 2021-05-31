package com.epam.travelAgency.entity;

import java.util.Objects;

public class TourCustomerEntity {
    private int id;
    private int tourId;
    private int customerId;

    public TourCustomerEntity() {
    }

    public TourCustomerEntity(int tourId, int customerId) {
        this.tourId = tourId;
        this.customerId = customerId;
    }

    public TourCustomerEntity(int id, int tourId, int customerId) {
        this.id = id;
        this.tourId = tourId;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourCustomerEntity that = (TourCustomerEntity) o;
        return id == that.id && tourId == that.tourId && customerId == that.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tourId, customerId);
    }
}

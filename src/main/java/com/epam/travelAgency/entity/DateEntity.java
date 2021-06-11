package com.epam.travelAgency.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class DateEntity implements Serializable {
    private int id;
    private LocalDate date;

    public DateEntity() {
    }

    public DateEntity(int id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    public DateEntity(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateEntity that = (DateEntity) o;
        return id == that.id && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date);
    }
}

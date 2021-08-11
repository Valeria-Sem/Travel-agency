package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.TourEntity;

import java.time.LocalDate;
import java.util.List;

public interface DateTourDAO {
    TourEntity getTourByDate(LocalDate ArrDate, LocalDate DepDate) throws DAOException;
    List<LocalDate> getArrivalDatesByIdTour(int tourId) throws DAOException;
    List<LocalDate> getDepartureDatesByIdTour(int tourId) throws DAOException;
    boolean deleteTourDatesById(int id) throws DAOException;

}

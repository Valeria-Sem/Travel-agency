package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.UserEntity;

import java.time.LocalDate;
import java.util.List;

public interface DateTourDAO {
    TourEntity getTourByDate(LocalDate ArrDate, LocalDate DepDate) throws DAOException;
    List<LocalDate> getArrivalDatesByIdTour(int tourId) throws DAOException;
    List<LocalDate> getDepartureDatesByIdTour(int tourId) throws DAOException;
    boolean addTourDates(int idTour, int idArrDate, int idDepDateT) throws DAOException;
    void deleteTourDates(int idTour, int idArrDate, int idDepDateT) throws DAOException;

}

package com.epam.travelAgency.service;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.UserEntity;

import java.time.LocalDate;
import java.util.List;

public interface DateTourService {
    TourEntity getTourByDate(LocalDate ArrDate, LocalDate DepDate) throws ServiceException;
    List<LocalDate> getArrivalDatesByIdTour(int tourId) throws ServiceException;
    List<LocalDate> getDepartureDatesByIdTour(int tourId) throws ServiceException;
    boolean addTourDates(int idTour, int idArrDate, int idDepDateT) throws ServiceException;
    void deleteTourDates(int idTour, int idArrDate, int idDepDateT) throws ServiceException;
}

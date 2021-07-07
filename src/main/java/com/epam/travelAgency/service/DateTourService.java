package com.epam.travelAgency.service;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.entity.TourEntity;

import java.time.LocalDate;
import java.util.List;

public interface DateTourService {
    TourEntity getTourByDate(LocalDate ArrDate, LocalDate DepDate) throws ServiceException;
    List<LocalDate> getArrivalDatesByIdTour(int tourId) throws ServiceException;
    List<LocalDate> getDepartureDatesByIdTour(int tourId) throws ServiceException;
}

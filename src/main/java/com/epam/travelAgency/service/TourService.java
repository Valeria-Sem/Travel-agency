package com.epam.travelAgency.service;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.TourStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface TourService {
    List<TourEntity> getAllTours() throws ServiceException;
    TourEntity getTourById(int id) throws ServiceException;
    boolean isTourStatusUpdate(int tourId, TourStatus tourStatus) throws ServiceException;
    List<TourEntity> getTourByStatus(TourStatus tourStatus) throws ServiceException;
    Set<TourEntity> getTourByStartParams(String category, String country, LocalDate arrDate, LocalDate depDate,
                                         int adults, int children) throws ServiceException;
    Set<TourEntity> getTourByStartParams(String category, String country,
                                         LocalDate arrDate,LocalDate depDate) throws ServiceException;
    Set<TourEntity> getTourByStartParams(String category, String country, LocalDate arrDate) throws ServiceException;
    void deleteTourById(int tourId) throws ServiceException;
}

package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.TourStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface TourDAO {
    List<TourEntity> getAllTours() throws DAOException;
    TourEntity getTourById(int id) throws DAOException;
//    List<TourEntity> getTourByCategory() throws DAOException;
//    List<TourEntity> getTourByCountry() throws DAOException;
    List<TourEntity> getTourByStatus(TourStatus tourStatus) throws DAOException;
    boolean isTourStatusUpdate(int tourId, TourStatus tourStatus) throws DAOException;
    //    List<TourEntity> filterTours() throws DAOException;
//    List<TourEntity> getTourByHotel() throws DAOException;
    Set<TourEntity> getTourByStartParams(String category, String country, LocalDate arrDate,LocalDate depDate,
                                         int adults, int children) throws DAOException;
    Set<TourEntity> getTourByStartParams(String category, String country, LocalDate arrDate,LocalDate depDate) throws DAOException;
    Set<TourEntity> getTourByStartParams(String category, String country, LocalDate arrDate) throws DAOException;
}

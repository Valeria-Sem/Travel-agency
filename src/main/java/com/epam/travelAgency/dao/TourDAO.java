package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.TourStatus;
import com.epam.travelAgency.entity.UserEntity;

import java.util.List;

public interface TourDAO {
    Iterable<TourEntity> getAllTours() throws DAOException;
    TourEntity getTourById(int id) throws DAOException;
    List<TourEntity> getTourByCategory() throws DAOException;
    List<TourEntity> getTourByCountry() throws DAOException;
    List<TourEntity> getTourByStatus(TourStatus tourStatus) throws DAOException;
    List<TourEntity> filterTours() throws DAOException;
    List<TourEntity> getTourByHotel() throws DAOException;

}

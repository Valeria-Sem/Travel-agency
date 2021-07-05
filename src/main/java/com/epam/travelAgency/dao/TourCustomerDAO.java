package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.service.ServiceException;

import java.util.List;

public interface TourCustomerDAO {
    boolean buyTour(int idUser, int idTour) throws DAOException;
    List<TourEntity> getAllCustomerTours(int idUser) throws DAOException;
}

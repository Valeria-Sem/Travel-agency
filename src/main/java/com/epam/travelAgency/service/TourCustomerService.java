package com.epam.travelAgency.service;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.entity.TourEntity;

import java.util.List;

public interface TourCustomerService {
    boolean buyTour(int idTour, int idUser) throws ServiceException;
    List<TourEntity> getAllCustomerTours(int idUser) throws ServiceException;
}

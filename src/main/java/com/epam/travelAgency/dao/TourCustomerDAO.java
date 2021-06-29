package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.UserEntity;

public interface TourCustomerDAO {
    boolean buyTour(int idUser, int idTour) throws DAOException;
}

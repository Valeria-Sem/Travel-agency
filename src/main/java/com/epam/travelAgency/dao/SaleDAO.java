package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.MealsEntity;
import com.epam.travelAgency.entity.SaleEntity;

import java.util.List;

public interface SaleDAO {
    SaleEntity getSaleByIdUser(int userId) throws DAOException;
    SaleEntity saveNewSaleInfo(int userId) throws DAOException;
    SaleEntity updateSaleInfo(int userId, int sale) throws DAOException;
    SaleEntity updateToursCount(int userId, int countOfTour) throws DAOException;
}

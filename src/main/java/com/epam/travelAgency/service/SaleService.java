package com.epam.travelAgency.service;

import com.epam.travelAgency.entity.SaleEntity;

public interface SaleService {
    SaleEntity getSaleByIdUser(int userId) throws ServiceException;
    SaleEntity saveNewSaleInfo(int userId) throws ServiceException;
    SaleEntity updateSaleInfo(int userId, int saleCount) throws ServiceException;
    SaleEntity updateToursCount(int userId, int toursCount) throws ServiceException;
}

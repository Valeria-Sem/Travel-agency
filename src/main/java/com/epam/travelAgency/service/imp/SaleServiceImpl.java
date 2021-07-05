package com.epam.travelAgency.service.imp;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.dao.SaleDAO;
import com.epam.travelAgency.entity.SaleEntity;
import com.epam.travelAgency.service.SaleService;
import com.epam.travelAgency.service.ServiceException;

public class SaleServiceImpl implements SaleService {
    @Override
    public SaleEntity getSaleByIdUser(int userId) throws ServiceException {
        SaleEntity sale;

        DAOProvider provider = DAOProvider.getInstance();
        SaleDAO saleDAO = provider.getSaleDAO();

        try{
            sale = saleDAO.getSaleByIdUser(userId);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return sale;
    }

    @Override
    public SaleEntity saveNewSaleInfo(int userId) throws ServiceException {
        SaleEntity sale;

        DAOProvider provider = DAOProvider.getInstance();
        SaleDAO saleDAO = provider.getSaleDAO();

        try{
            sale = saleDAO.saveNewSaleInfo(userId);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return sale;
    }

    @Override
    public SaleEntity updateSaleInfo(int userId, int saleCount) throws ServiceException {
        SaleEntity sale;

        DAOProvider provider = DAOProvider.getInstance();
        SaleDAO saleDAO = provider.getSaleDAO();

        try{
            sale = saleDAO.updateSaleInfo(userId, saleCount);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return sale;
    }

    @Override
    public SaleEntity updateToursCount(int userId, int toursCount) throws ServiceException {
        SaleEntity sale;

        DAOProvider provider = DAOProvider.getInstance();
        SaleDAO saleDAO = provider.getSaleDAO();

        try{
            sale = saleDAO.updateToursCount(userId, toursCount);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return sale;
    }
}

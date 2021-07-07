package com.epam.travelAgency.service.imp;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.dao.TourCustomerDAO;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.TourCustomerService;

import java.util.List;

public class TourCustomerServiceImpl implements TourCustomerService {
    @Override
    public boolean buyTour(int idTour, int idUser) throws ServiceException {
        boolean isOk;

        DAOProvider provider = DAOProvider.getInstance();
        TourCustomerDAO tourCustomerDAO = provider.getTourCustomerDAO();

        try{
            isOk = tourCustomerDAO.buyTour(idTour, idUser);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isOk;
    }

    @Override
    public List<TourEntity> getAllCustomerTours(int idUser) throws ServiceException {
        List<TourEntity> tours;

        DAOProvider provider = DAOProvider.getInstance();
        TourCustomerDAO tourCustomerDAO = provider.getTourCustomerDAO();

        try{
            tours = tourCustomerDAO.getAllCustomerTours(idUser);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return tours;
    }
}

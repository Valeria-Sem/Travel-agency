package com.epam.travelAgency.service.imp;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.dao.TransportDAO;
import com.epam.travelAgency.entity.TransportEntity;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.TransportService;

import java.util.List;

public class TransportServiceImpl implements TransportService {

    @Override
    public List<TransportEntity> getAllTransport() throws ServiceException {
        List<TransportEntity> transports;

        DAOProvider provider = DAOProvider.getInstance();
        TransportDAO transportDAO = provider.getTransportDAO();

        try{
            transports = transportDAO.getAllTransport();
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return transports;
    }

    @Override
    public int getIdByName(String transport) throws ServiceException {
        int id;

        DAOProvider provider = DAOProvider.getInstance();
        TransportDAO transportDAO = provider.getTransportDAO();

        try{
            id = transportDAO.getIdByName(transport);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return id;
    }
}

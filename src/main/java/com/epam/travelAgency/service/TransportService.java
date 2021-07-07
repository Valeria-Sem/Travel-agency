package com.epam.travelAgency.service;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.entity.TransportEntity;

import java.util.List;

public interface TransportService {
    List<TransportEntity> getAllTransport() throws ServiceException;
    int getIdByName(String transport) throws ServiceException;
    TransportEntity getTransportById(int transportId) throws ServiceException;
}

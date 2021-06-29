package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.TransportEntity;

import java.util.List;

public interface TransportDAO {
    List<TransportEntity> getAllTransport() throws DAOException;
    int getIdByName(String transport) throws DAOException;
}

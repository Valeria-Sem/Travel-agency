package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.TransportDAO;
import com.epam.travelAgency.entity.TransportEntity;

import java.util.List;

public class TransportDaoImpl implements TransportDAO {
    @Override
    public List<TransportEntity> getAllTransport() throws DAOException {
        return null;
    }

    @Override
    public int getIdByName(String transport) throws DAOException {
        return 0;
    }
}

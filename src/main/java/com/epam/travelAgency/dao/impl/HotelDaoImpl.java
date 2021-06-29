package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.HotelDAO;
import com.epam.travelAgency.entity.HotelEntity;

import java.util.List;

public class HotelDaoImpl implements HotelDAO {
    @Override
    public List<HotelEntity> getAllHotels() throws DAOException {
        return null;
    }

    @Override
    public int getIdByName(String name) throws DAOException {
        return 0;
    }
}

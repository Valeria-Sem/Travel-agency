package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.DateEntity;
import com.epam.travelAgency.entity.HotelEntity;

import java.time.LocalDate;
import java.util.List;

public interface HotelDAO {
    List<HotelEntity> getAllHotels() throws DAOException;
    HotelEntity getHotelById(int id) throws DAOException;
    int getIdByName(String name) throws DAOException;
}

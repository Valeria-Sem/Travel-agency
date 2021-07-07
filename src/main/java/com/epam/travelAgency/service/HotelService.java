package com.epam.travelAgency.service;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.entity.HotelEntity;

import java.util.List;

public interface HotelService {
    List<HotelEntity> getAllHotels() throws ServiceException;
    int getIdByName(String name) throws ServiceException;
    HotelEntity getHotelById(int hotelId) throws ServiceException;
}

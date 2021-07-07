package com.epam.travelAgency.service.imp;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.dao.HotelDAO;
import com.epam.travelAgency.entity.HotelEntity;
import com.epam.travelAgency.service.HotelService;
import com.epam.travelAgency.service.ServiceException;

import java.util.List;

public class HotelServiceImpl implements HotelService {
    @Override
    public List<HotelEntity> getAllHotels() throws ServiceException {
        List<HotelEntity> hotels;

        DAOProvider provider = DAOProvider.getInstance();
        HotelDAO hotelDAO = provider.getHotelDAO();

        try{
            hotels = hotelDAO.getAllHotels();
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return hotels;
    }

    @Override
    public int getIdByName(String name) throws ServiceException {
        int id;

        DAOProvider provider = DAOProvider.getInstance();
        HotelDAO hotelDAO = provider.getHotelDAO();

        try{
            id = hotelDAO.getIdByName(name);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return id;
    }

    @Override
    public HotelEntity getHotelById(int hotelId) throws ServiceException {
        HotelEntity hotel;

        DAOProvider provider = DAOProvider.getInstance();
        HotelDAO hotelDAO = provider.getHotelDAO();

        try{
            hotel = hotelDAO.getHotelById(hotelId);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return hotel;
    }
}

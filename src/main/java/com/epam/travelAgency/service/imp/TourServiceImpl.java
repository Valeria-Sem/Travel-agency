package com.epam.travelAgency.service.imp;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.dao.TourDAO;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.TourStatus;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.TourService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class TourServiceImpl implements TourService {

    @Override
    public Iterable<TourEntity> getAllTours() throws ServiceException {
        Iterable<TourEntity> tours;

        DAOProvider provider = DAOProvider.getInstance();
        TourDAO tourDAO = provider.getTourDAO();

        try{
            tours = tourDAO.getAllTours();
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return tours;
    }

    @Override
    public TourEntity getTourById(int id) throws ServiceException {
        TourEntity tour;

        DAOProvider provider = DAOProvider.getInstance();
        TourDAO tourDAO = provider.getTourDAO();

        try{
            tour = tourDAO.getTourById(id);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return tour;
    }

    @Override
    public List<TourEntity> getTourByStatus(TourStatus tourStatus) throws ServiceException {
        List<TourEntity> tours;

        DAOProvider provider = DAOProvider.getInstance();
        TourDAO tourDAO = provider.getTourDAO();

        try{
            tours = tourDAO.getTourByStatus(tourStatus);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return tours;
    }

    @Override
    public Set<TourEntity> getTourByStartParams(String category, String country, LocalDate arrDate, LocalDate depDate,
                                                int adults, int children) throws ServiceException {
        Set<TourEntity> tours;

        DAOProvider provider = DAOProvider.getInstance();
        TourDAO tourDAO = provider.getTourDAO();

        try{
            tours = tourDAO.getTourByStartParams(category, country, arrDate,
                    depDate, adults, children);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return tours;
    }

    @Override
    public Set<TourEntity> getTourByStartParams(String category, String country,
                                                LocalDate arrDate, LocalDate depDate) throws ServiceException {
        Set<TourEntity> tours;

        DAOProvider provider = DAOProvider.getInstance();
        TourDAO tourDAO = provider.getTourDAO();

        try{
            tours = tourDAO.getTourByStartParams(category, country, arrDate, depDate);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return tours;
    }

    @Override
    public Set<TourEntity> getTourByStartParams(String category, String country,
                                                LocalDate arrDate) throws ServiceException {
        Set<TourEntity> tours;

        DAOProvider provider = DAOProvider.getInstance();
        TourDAO tourDAO = provider.getTourDAO();

        try{
            tours = tourDAO.getTourByStartParams(category, country, arrDate);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return tours;
    }
}

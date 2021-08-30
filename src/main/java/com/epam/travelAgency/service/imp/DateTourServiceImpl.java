package com.epam.travelAgency.service.imp;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.dao.DateTourDAO;
import com.epam.travelAgency.dao.UserDAO;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.service.DateTourService;
import com.epam.travelAgency.service.ServiceException;

import java.time.LocalDate;
import java.util.List;

public class DateTourServiceImpl implements DateTourService {

    @Override
    public TourEntity getTourByDate(LocalDate arrDate, LocalDate depDate) throws ServiceException {
        TourEntity tour;

        DAOProvider provider = DAOProvider.getInstance();
        DateTourDAO dateTourDAO = provider.getDateTourDAO();
        try{
            tour = dateTourDAO.getTourByDate(arrDate,depDate);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return tour;
    }

    @Override
    public List<LocalDate> getArrivalDatesByIdTour(int tourId) throws ServiceException {
        List<LocalDate> dates;

        DAOProvider provider = DAOProvider.getInstance();
        DateTourDAO dateTourDAO = provider.getDateTourDAO();
        try{
            dates = dateTourDAO.getArrivalDatesByIdTour(tourId);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return dates;
    }

    @Override
    public List<LocalDate> getDepartureDatesByIdTour(int tourId) throws ServiceException {
        List<LocalDate> dates;

        DAOProvider provider = DAOProvider.getInstance();
        DateTourDAO dateTourDAO = provider.getDateTourDAO();
        try{
            dates = dateTourDAO.getDepartureDatesByIdTour(tourId);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return dates;
    }

    @Override
    public boolean addTourDates(int idTour, int idArrDate, int idDepDateT) throws ServiceException {
        boolean isAdded;

        DAOProvider provider = DAOProvider.getInstance();
        DateTourDAO dateTourDAO = provider.getDateTourDAO();

        try{
            isAdded = dateTourDAO.addTourDates(idTour, idArrDate, idDepDateT);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isAdded;
    }

    @Override
    public void deleteTourDates(int idTour, int idArrDate, int idDepDateT) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        DateTourDAO dateTourDAO = provider.getDateTourDAO();
        try{
            dateTourDAO.deleteTourDates(idTour, idArrDate, idDepDateT);
        } catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}

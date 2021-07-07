package com.epam.travelAgency.service.imp;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.dao.DateTourDAO;
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
}

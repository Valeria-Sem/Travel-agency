package com.epam.travelAgency.service.imp;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.dao.DateDAO;
import com.epam.travelAgency.entity.DateEntity;
import com.epam.travelAgency.service.DateService;
import com.epam.travelAgency.service.ServiceException;

import java.time.LocalDate;
import java.util.List;

public class DateServiceImpl implements DateService {
    @Override
    public List<DateEntity> getAllDates() throws ServiceException {
        List<DateEntity> dates;

        DAOProvider provider = DAOProvider.getInstance();
        DateDAO dateDAO = provider.getDateDAO();
        try{
            dates = dateDAO.getAllDates();
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return dates;
    }

    @Override
    public int getIdByDate(LocalDate date) throws ServiceException {
        int id;

        DAOProvider provider = DAOProvider.getInstance();
        DateDAO dateDAO = provider.getDateDAO();
        try{
            id = dateDAO.getIdByDate(date);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return id;
    }
}

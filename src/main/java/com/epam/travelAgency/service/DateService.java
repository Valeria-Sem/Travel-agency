package com.epam.travelAgency.service;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.entity.DateEntity;

import java.time.LocalDate;
import java.util.List;

public interface DateService {
    List<DateEntity> getAllDates() throws ServiceException;
    int getIdByDate(LocalDate date) throws ServiceException;
}

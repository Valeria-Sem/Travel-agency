package com.epam.travelAgency.service;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.entity.TourEntity;

import java.time.LocalDate;

public interface DateTourService {
    TourEntity getTourByDate(LocalDate ArrDate, LocalDate DepDate) throws ServiceException;

}

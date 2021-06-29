package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DateTourDAO;
import com.epam.travelAgency.entity.TourEntity;

import java.time.LocalDate;

public class DateTourDaoImpl implements DateTourDAO {
    @Override
    public TourEntity getTourByDate(LocalDate ArrDate, LocalDate DepDate) throws DAOException {
        return null;
    }
}

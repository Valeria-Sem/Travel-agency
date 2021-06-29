package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.TourEntity;

import java.time.LocalDate;

public interface DateTourDAO {
    TourEntity getTourByDate(LocalDate ArrDate, LocalDate DepDate) throws DAOException;
}

package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.DateEntity;
import com.epam.travelAgency.entity.UserEntity;

import java.time.LocalDate;
import java.util.List;

public interface DateDAO {
    List<DateEntity> getAllDates() throws DAOException;
    int getIdByDate(LocalDate date) throws DAOException;
}

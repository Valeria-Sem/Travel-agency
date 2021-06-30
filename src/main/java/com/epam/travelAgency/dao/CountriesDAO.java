package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.CountriesEntity;
import com.epam.travelAgency.entity.DateEntity;

import java.util.List;

public interface CountriesDAO {
    List<CountriesEntity> getAllCountries() throws DAOException;

}

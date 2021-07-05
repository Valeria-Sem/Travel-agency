package com.epam.travelAgency.service;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.entity.CountriesEntity;

import java.util.List;

public interface CountriesService {
    List<CountriesEntity> getAllCountries() throws ServiceException;

}

package com.epam.travelAgency.service.imp;

import com.epam.travelAgency.dao.CountriesDAO;
import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.entity.CountriesEntity;
import com.epam.travelAgency.service.CountriesService;
import com.epam.travelAgency.service.ServiceException;

import java.util.List;

public class CountriesServiceImpl implements CountriesService {

    @Override
    public List<CountriesEntity> getAllCountries() throws ServiceException {
        List<CountriesEntity> countries;

        DAOProvider provider = DAOProvider.getInstance();
        CountriesDAO countriesDAO = provider.getCountriesDAO();

        try{
            countries = countriesDAO.getAllCountries();
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return countries;
    }
}

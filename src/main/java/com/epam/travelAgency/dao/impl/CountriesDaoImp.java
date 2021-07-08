package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.CountriesDAO;
import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.pool.ConnectionPool;
import com.epam.travelAgency.dao.pool.ConnectionPoolException;
import com.epam.travelAgency.entity.CountriesEntity;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.TourStatus;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountriesDaoImp implements CountriesDAO {
    private final Logger LOGGER = Logger.getLogger(CountriesDaoImp.class);

    private final String queryForGetAllCountries = "select * from countries";
    private final String id ="id";
    private final String name ="name";



    @Override
    public List<CountriesEntity> getAllCountries() throws DAOException {
        List<CountriesEntity> countries = new ArrayList<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(queryForGetAllCountries);
            ResultSet res = ps.executeQuery();

            while (res.next()){
                CountriesEntity country = new CountriesEntity();

                country.setId(Integer.parseInt(res.getString(id)));
                country.setName(res.getString(name));

                countries.add(country);
            }
        } catch (ConnectionPoolException | SQLException e){
            LOGGER.error("UserDetailsDAOImpl (getAllUserDetails) -> some problems with extracting userDet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps);
            }
        }

        return countries;
    }
}

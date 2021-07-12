package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DateDAO;
import com.epam.travelAgency.dao.pool.ConnectionPool;
import com.epam.travelAgency.dao.pool.ConnectionPoolException;
import com.epam.travelAgency.entity.DateEntity;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateDaoImpl implements DateDAO {
    private final Logger LOGGER = Logger.getLogger(DateDaoImpl.class);

    private final String queryForGetAllDate = "select * from date";
    private final String queryForGetId = "select id from date where date = '" ;
    private final String i ="'";
    private final String id ="id";
    private final String DATE ="date";
    private final String GET_ARRIVAL_DATES = "select date.date from tour, date_tour, date where tour.id = date_tour.id_tour and " +
            "date.id = date_tour.id_arrival_date and tour.id = ?";

    @Override
    public List<DateEntity> getAllDates() throws DAOException {
        List<DateEntity> dates = new ArrayList<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(queryForGetAllDate);
            res = ps.executeQuery();

            while (res.next()){
                DateEntity dateEntity = new DateEntity();
                dateEntity.setId(Integer.parseInt(res.getString(id)));
                dateEntity.setDate(LocalDate.parse(res.getString(DATE)));

                dates.add(dateEntity);
            }
        } catch (ConnectionPoolException | SQLException e){
            LOGGER.error("DateDaoImpl (getAllDates) -> some problems with extracting dates");
            throw new DAOException(e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return dates;
    }

    @Override
    public int getIdByDate(LocalDate date) throws DAOException {
        int dateId = 0;

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(queryForGetId + date + i);
            res = ps.executeQuery();

            while (res.next()){
                dateId  = res.getInt(id);
            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("DateDaoImpl (getIdByDate) -> some problems with extracting id date");
            throw new DAOException(e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return dateId;
    }

}

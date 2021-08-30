package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DateTourDAO;
import com.epam.travelAgency.dao.pool.ConnectionPool;
import com.epam.travelAgency.dao.pool.ConnectionPoolException;
import com.epam.travelAgency.entity.TourEntity;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateTourDaoImpl implements DateTourDAO {
    private final Logger LOGGER = Logger.getLogger(DateTourDaoImpl.class);

    private final String GET_DEPARTURE_DATES = "select date.date from tour, date_tour, date where tour.id = date_tour.id_tour " +
            "and date.id = date_tour.id_departure_date and tour.id = ?";
    private final String GET_ARRIVAL_DATES = "select date.date from tour, date_tour, date where tour.id = date_tour.id_tour and " +
            "date.id = date_tour.id_arrival_date and tour.id = ?";
    private final String DATE = "date";
    private final String DELETE_QUERY = "delete from date_tour where id_tour = ? and id_arrival_date = ? and id_departure_date = ?";
    private final String INSERT_QUERY = "insert into date_tour (id_arrival_date, id_departure_date, id_tour) values (?, ?, ?)";

    private final String ID = "id";
    private final String ID_TOUR = "id_tour";
    private final String ID_ARRIVAL_DATE = "id_arrival_date";
    private final String ID_DEPARTURE_DATE = "id_departure_date";



    @Override
    public TourEntity getTourByDate(LocalDate ArrDate, LocalDate DepDate) throws DAOException {
        return null;
    }

    @Override
    public List<LocalDate> getArrivalDatesByIdTour(int tourId) throws DAOException {
        List<LocalDate> dates = new ArrayList<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(GET_ARRIVAL_DATES);

            ps.setInt(1, tourId);

            res = ps.executeQuery();

            while (res.next()){
                LocalDate date = LocalDate.parse(res.getString(DATE));

                dates.add(date);
            }

            connection.close();
            ps.close();

        } catch (ConnectionPoolException | SQLException e){
            LOGGER.error("DateTourDaoImpl (getArrivalDatesByIdTour) -> some problems with extracting dates");
            throw new DAOException(e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return dates;
    }

    @Override
    public List<LocalDate> getDepartureDatesByIdTour(int tourId) throws DAOException {
        List<LocalDate> dates = new ArrayList<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(GET_DEPARTURE_DATES);

            ps.setInt(1, tourId);

            res = ps.executeQuery();

            while (res.next()){
                LocalDate date = LocalDate.parse(res.getString(DATE));

                dates.add(date);
            }

            connection.close();
            ps.close();

        } catch (ConnectionPoolException | SQLException e){
            LOGGER.error("DateTourDaoImpl (getDepartureDatesByIdTour) -> some problems with extracting dates");
            throw new DAOException(e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return dates;
    }

    @Override
    public boolean addTourDates(int idTour, int idArrDate, int idDepDateT) throws DAOException {
        boolean isAdded = false;
        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(INSERT_QUERY);

            statement.setInt(1, idArrDate);
            statement.setInt(2, idDepDateT);
            statement.setInt(3, idTour);

            statement.executeUpdate();

            isAdded = true;

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error(" -> some problems with adding dates");
            throw new DAOException(e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }

        return isAdded;
    }

    @Override
    public void deleteTourDates(int idTour, int idArrDateT, int idDepDateT) throws DAOException {
        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(DELETE_QUERY);
            statement.setInt(1, idTour);
            statement.setInt(2, idArrDateT);
            statement.setInt(3, idDepDateT);

            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error(" -> some problems with deleting tour dates");
            throw new DAOException(e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }
    }


}

package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.TourCustomerDAO;
import com.epam.travelAgency.dao.pool.ConnectionPool;
import com.epam.travelAgency.dao.pool.ConnectionPoolException;
import com.epam.travelAgency.entity.*;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourCustomerDaoImpl implements TourCustomerDAO {
    private final Logger LOGGER = Logger.getLogger(TourCustomerDaoImpl.class);

    private final String insertQuery = "insert into tour_customer (tour_id, user_id) values(?, ?);";
    private final String selectQuery = "select tour.* from tour, tour_customer where tour.id = tour_customer.tour_id and" +
            " tour_customer.user_id = ?";


    private final String idS ="id";
    private final String nameS ="name";
    private final String descriptionS ="description";
    private final String priceS ="price";
    private final String imgPathS ="img_path";
    private final String statusS ="status";
    private final String adultsS ="adults";
    private final String childrenS ="children";
    private final String idCategoryS ="id_category";
    private final String idHotelS ="id_hotel";
    private final String idMealsS ="id_meals";
    private final String idTransportS ="id_transport";
    private final String countryIdS ="country_id";

    @Override
    public boolean buyTour(int idTour, int idUser) throws DAOException {
        boolean isAdded = false;

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(insertQuery);

            statement.setInt(1, idTour);
            statement.setInt(2, idUser);

            statement.executeUpdate();

            isAdded = true;

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error(" -> some problems with buy tour");
            throw new DAOException(e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }

        return isAdded;
    }

    @Override
    public List<TourEntity> getAllCustomerTours(int idUser) throws DAOException {
        List<TourEntity> tours = new ArrayList<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(selectQuery);

            ps.setInt(1, idUser);

            res = ps.executeQuery();

            while (res.next()){
                TourEntity tour = new TourEntity();

                tour.setId(Integer.parseInt(res.getString(idS)));
                tour.setName(res.getString(nameS));
                tour.setDescription(res.getString(descriptionS));
                tour.setPrice(Integer.parseInt(res.getString(priceS)));
                tour.setImgPath(res.getString(imgPathS));
                tour.setStatus(TourStatus.valueOf(res.getString(statusS)));
                tour.setAdults(Integer.parseInt(res.getString(adultsS)));
                tour.setChildren(Integer.parseInt(res.getString(childrenS)));
                tour.setIdCategory(Integer.parseInt(res.getString(idCategoryS)));
                tour.setIdHotel(Integer.parseInt(res.getString(idHotelS)));
                tour.setIdMeals(Integer.parseInt(res.getString(idMealsS)));
                tour.setIdTransport(Integer.parseInt(res.getString(idTransportS)));
                tour.setCountryId(Integer.parseInt(res.getString(countryIdS)));

                tours.add(tour);
            }
        } catch (ConnectionPoolException | SQLException e){
            LOGGER.error("-> some problems with extracting tours");
            e.printStackTrace();
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return tours;
    }
}

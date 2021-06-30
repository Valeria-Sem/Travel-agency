package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.TourDAO;
import com.epam.travelAgency.dao.pool.ConnectionPool;
import com.epam.travelAgency.dao.pool.ConnectionPoolException;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.TourStatus;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TourDaoImpl implements TourDAO {
    private final Logger LOGGER = Logger.getLogger(TourDaoImpl.class);

    private final String queryForGetAllTours = "select * from tour";
    private final String queryForGetToursByStatus = "select * from tour where status = '";

    private final String q1 = "SELECT tour.* FROM tour, date_tour where tour.id = date_tour.id_tour and " +
            "(date_tour.id_arrival_date) >= any( SELECT id FROM date WHERE date.date ='";
    private final String q2 = "' ) and (date_tour.id_departure_date) <= any(SELECT id FROM date WHERE date.date ='";
    private final String q3 = "') and tour.country_id = any (select id from countries where name = '";
    private final String q4 = "') and tour.id_category = any (select id from category where name = '" ;
    private final String q5 = "') and adults = " ;
    private final String q6 = " and children = " ;
    private final String q7 = " order by tour.price asc;";

    private final String quote ="'";
    private final String bracket = ")";
    private final String id ="id";
    private final String name ="name";
    private final String description ="description";
    private final String price ="price";
    private final String imgPath ="img_path";
    private final String status ="status";
    private final String adults ="adults";
    private final String children ="children";
    private final String idCategory ="id_category";
    private final String idHotel ="id_hotel";
    private final String idMeals ="id_meals";
    private final String idTransport ="id_transport";
    private final String countryId ="country_id";

    @Override
    public Iterable<TourEntity> getAllTours() throws DAOException {
        List<TourEntity> tours = new ArrayList<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(queryForGetAllTours);
            ResultSet res = ps.executeQuery();

            while (res.next()){
                TourEntity tour = new TourEntity();

                tour.setId(Integer.parseInt(res.getString(id)));
                tour.setName(res.getString(name));
                tour.setDescription(res.getString(description));
                tour.setPrice(Integer.parseInt(res.getString(price)));
                tour.setImgPath(res.getString(imgPath));
                tour.setStatus(TourStatus.valueOf(res.getString(status)));
                tour.setAdults(Integer.parseInt(res.getString(adults)));
                tour.setChildren(Integer.parseInt(res.getString(children)));
                tour.setIdCategory(Integer.parseInt(res.getString(idCategory)));
                tour.setIdHotel(Integer.parseInt(res.getString(idHotel)));
                tour.setIdMeals(Integer.parseInt(res.getString(idMeals)));
                tour.setIdTransport(Integer.parseInt(res.getString(idTransport)));
                tour.setСountryId(Integer.parseInt(res.getString(countryId)));

                tours.add(tour);
            }
        } catch (ConnectionPoolException | SQLException e){
            LOGGER.error("UserDetailsDAOImpl (getAllUserDetails) -> some problems with extracting userDet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps);
            }
        }

        return tours;
    }

    @Override
    public TourEntity getTourById(int id) throws DAOException {
        return null;
    }

//    @Override
//    public List<TourEntity> getTourByCategory() throws DAOException {
//        return null;
//    }
//
//    @Override
//    public List<TourEntity> getTourByCountry() throws DAOException {
//        return null;
//    }

    @Override
    public List<TourEntity> getTourByStatus(TourStatus tourStatus) throws DAOException {
        List<TourEntity> tours = new ArrayList<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(queryForGetToursByStatus + tourStatus + quote);
            ResultSet res = ps.executeQuery();

            while (res.next()){
                TourEntity tour = new TourEntity();

                tour.setId(Integer.parseInt(res.getString(id)));
                tour.setName(res.getString(name));
                tour.setDescription(res.getString(description));
                tour.setPrice(Integer.parseInt(res.getString(price)));
                tour.setImgPath(res.getString(imgPath));
                tour.setStatus(TourStatus.valueOf(res.getString(status)));
                tour.setAdults(Integer.parseInt(res.getString(adults)));
                tour.setChildren(Integer.parseInt(res.getString(children)));
                tour.setIdCategory(Integer.parseInt(res.getString(idCategory)));
                tour.setIdHotel(Integer.parseInt(res.getString(idHotel)));
                tour.setIdMeals(Integer.parseInt(res.getString(idMeals)));
                tour.setIdTransport(Integer.parseInt(res.getString(idTransport)));
                tour.setСountryId(Integer.parseInt(res.getString(countryId)));

                tours.add(tour);
            }
        } catch (ConnectionPoolException | SQLException e){
            LOGGER.error("UserDetailsDAOImpl (getAllUserDetails) -> some problems with extracting userDet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps);
            }
        }

        return tours;
    }

//    @Override
//    public List<TourEntity> filterTours() throws DAOException {
//        return null;
//    }
//
//    @Override
//    public List<TourEntity> getTourByHotel() throws DAOException {
//        return null;
//    }

    @Override
    public Set<TourEntity> getTourByStartParams(String category, String country, LocalDate arrDate, LocalDate depDate,
                                                int adults1, int children1) throws DAOException {
        Set<TourEntity> tours = new HashSet<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(q1 + arrDate + q2 + depDate + q3 + country + q4 + category +
                    q5 + adults1 + q6 + children1 + q7);
            ResultSet res = ps.executeQuery();

            while (res.next()){
                TourEntity tour = new TourEntity();

                tour.setId(Integer.parseInt(res.getString(id)));
                tour.setName(res.getString(name));
                tour.setDescription(res.getString(description));
                tour.setPrice(Integer.parseInt(res.getString(price)));
                tour.setImgPath(res.getString(imgPath));
                tour.setStatus(TourStatus.valueOf(res.getString(status)));
                tour.setAdults(Integer.parseInt(res.getString(adults)));
                tour.setChildren(Integer.parseInt(res.getString(children)));
                tour.setIdCategory(Integer.parseInt(res.getString(idCategory)));
                tour.setIdHotel(Integer.parseInt(res.getString(idHotel)));
                tour.setIdMeals(Integer.parseInt(res.getString(idMeals)));
                tour.setIdTransport(Integer.parseInt(res.getString(idTransport)));
                tour.setСountryId(Integer.parseInt(res.getString(countryId)));

                tours.add(tour);
            }
        } catch (ConnectionPoolException | SQLException e){
            LOGGER.error("UserDetailsDAOImpl (getAllUserDetails) -> some problems with extracting userDet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps);
            }
        }

        return tours;
    }

    @Override
    public Set<TourEntity> getTourByStartParams(String category, String country, LocalDate arrDate, LocalDate depDate) throws DAOException {
        Set<TourEntity> tours = new HashSet<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(q1 + arrDate + q2 + depDate + q3 + country + q4 + category + quote + bracket);
            ResultSet res = ps.executeQuery();

            while (res.next()){
                TourEntity tour = new TourEntity();

                tour.setId(Integer.parseInt(res.getString(id)));
                tour.setName(res.getString(name));
                tour.setDescription(res.getString(description));
                tour.setPrice(Integer.parseInt(res.getString(price)));
                tour.setImgPath(res.getString(imgPath));
                tour.setStatus(TourStatus.valueOf(res.getString(status)));
                tour.setAdults(Integer.parseInt(res.getString(adults)));
                tour.setChildren(Integer.parseInt(res.getString(children)));
                tour.setIdCategory(Integer.parseInt(res.getString(idCategory)));
                tour.setIdHotel(Integer.parseInt(res.getString(idHotel)));
                tour.setIdMeals(Integer.parseInt(res.getString(idMeals)));
                tour.setIdTransport(Integer.parseInt(res.getString(idTransport)));
                tour.setСountryId(Integer.parseInt(res.getString(countryId)));

                tours.add(tour);
            }
        } catch (ConnectionPoolException | SQLException e){
            LOGGER.error("UserDetailsDAOImpl (getAllUserDetails) -> some problems with extracting userDet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps);
            }
        }

        return tours;
    }

    @Override
    public Set<TourEntity> getTourByStartParams(String category, String country, LocalDate arrDate) throws DAOException {
        Set<TourEntity> tours = new HashSet<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(q1 + arrDate + q3 + country + q4 + category + quote + bracket);
            ResultSet res = ps.executeQuery();

            while (res.next()){
                TourEntity tour = new TourEntity();

                tour.setId(Integer.parseInt(res.getString(id)));
                tour.setName(res.getString(name));
                tour.setDescription(res.getString(description));
                tour.setPrice(Integer.parseInt(res.getString(price)));
                tour.setImgPath(res.getString(imgPath));
                tour.setStatus(TourStatus.valueOf(res.getString(status)));
                tour.setAdults(Integer.parseInt(res.getString(adults)));
                tour.setChildren(Integer.parseInt(res.getString(children)));
                tour.setIdCategory(Integer.parseInt(res.getString(idCategory)));
                tour.setIdHotel(Integer.parseInt(res.getString(idHotel)));
                tour.setIdMeals(Integer.parseInt(res.getString(idMeals)));
                tour.setIdTransport(Integer.parseInt(res.getString(idTransport)));
                tour.setСountryId(Integer.parseInt(res.getString(countryId)));

                tours.add(tour);
            }
        } catch (ConnectionPoolException | SQLException e){
            LOGGER.error("UserDetailsDAOImpl (getAllUserDetails) -> some problems with extracting userDet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps);
            }
        }

        return tours;
    }
}

package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.HotelDAO;
import com.epam.travelAgency.dao.pool.ConnectionPool;
import com.epam.travelAgency.dao.pool.ConnectionPoolException;
import com.epam.travelAgency.entity.HotelEntity;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HotelDaoImpl implements HotelDAO {
    private final Logger LOGGER = Logger.getLogger(HotelDaoImpl.class);

    private final String GET_HOTEL_BY_ID_QUERY = "select * from hotel where id = ?";

    private final String ID ="id";
    private final String NAME ="name";
    private final String STARS ="stars";
    private final String COASTLINE ="coastline";
    private final String BEACH ="beach";

    @Override
    public List<HotelEntity> getAllHotels() throws DAOException {
        return null;
    }

    @Override
    public HotelEntity getHotelById(int hotelId) throws DAOException {
        HotelEntity hotel = null;

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(GET_HOTEL_BY_ID_QUERY);
            ps.setInt(1, hotelId);

            res = ps.executeQuery();

            while (res.next()){
                int id  = res.getInt(ID);
                String name = res.getString(NAME);
                int stars = res.getInt(STARS);
                int coastline = res.getInt(COASTLINE);
                String beach = res.getString(BEACH);

                hotel = new HotelEntity(id, name, stars, coastline, beach) ;

            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("MealsDaoImpl (getMealsById) -> some problems with extracting MEALS");
            throw new DAOException(e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return hotel;
    }

    @Override
    public int getIdByName(String name) throws DAOException {
        return 0;
    }
}

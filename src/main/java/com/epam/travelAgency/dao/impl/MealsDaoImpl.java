package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.MealsDAO;
import com.epam.travelAgency.dao.pool.ConnectionPool;
import com.epam.travelAgency.dao.pool.ConnectionPoolException;
import com.epam.travelAgency.entity.MealsEntity;
import com.epam.travelAgency.entity.TransportEntity;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MealsDaoImpl implements MealsDAO {
    private final Logger LOGGER = Logger.getLogger(MealsDaoImpl.class);

    private final String updateCountQuery ="UPDATE sale SET tours_count = ? WHERE id_user = ?";
    private final String updateSaleQuery ="UPDATE sale SET sale = ? WHERE id_user = ?";
    private final String insertQuery = "insert into sale (id_user) values(?) ";
    private final String GET_MEALS_BY_ID_QUERY = "select * from meals where id = ?";

    private final String ID ="id";
    private final String NAME ="name";

    @Override
    public List<MealsEntity> getAllMeals() throws DAOException {
        return null;
    }

    @Override
    public MealsEntity getMealsById(int mealsId) throws DAOException {
        MealsEntity meals = null;

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(GET_MEALS_BY_ID_QUERY);
            ps.setInt(1, mealsId);

            res = ps.executeQuery();

            while (res.next()){
                int id  = res.getInt(ID);
                String name = res.getString(NAME);

                meals = new MealsEntity(id, name) ;

            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("MealsDaoImpl (getMealsById) -> some problems with extracting MEALS");

        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return meals;
    }

    @Override
    public int getIdByName(String meals) throws DAOException {
        return 0;
    }
}

package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.CategoryDAO;
import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.pool.ConnectionPool;
import com.epam.travelAgency.dao.pool.ConnectionPoolException;
import com.epam.travelAgency.entity.CategoryEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.UserRole;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDAO {
    private final Logger LOGGER = Logger.getLogger(CategoryDaoImpl.class);

    private static final String queryForGetAllCategories ="select * from category";
    private static final String id ="id";
    private static final String name ="name";

    @Override
    public Iterable<CategoryEntity> getAllCategories() throws DAOException {
        List<CategoryEntity> categories = new ArrayList<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(queryForGetAllCategories);
            ResultSet res = ps.executeQuery();

            while (res.next()){
                CategoryEntity category = new CategoryEntity();
                category.setId(Integer.parseInt(res.getString(id)));
                category.setName(res.getString(name));

                categories.add(category);
            }
        } catch (ConnectionPoolException | SQLException e){
            LOGGER.error("CategoryDaoImpl (getAllCategories) -> some problems with extracting categories");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps);
            }
        }

        return categories;
    }
}

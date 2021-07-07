package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.SaleDAO;
import com.epam.travelAgency.dao.pool.ConnectionPool;
import com.epam.travelAgency.dao.pool.ConnectionPoolException;
import com.epam.travelAgency.entity.SaleEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.UserRole;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SaleDaoImpl implements SaleDAO {
    private final Logger LOGGER = Logger.getLogger(SaleDaoImpl.class);

    private final String updateCountQuery ="UPDATE sale SET tours_count = ? WHERE id_user = ?";
    private final String updateSaleQuery ="UPDATE sale SET sale = ? WHERE id_user = ?";
    private final String insertQuery = "insert into sale (id_user) values(?) ";
    private final String getSaleByIdUserQuery = "select * from sale where id_user = ?";

    private final String id ="id";
    private final String idUser ="id_user";
    private final String sale ="sale";
    private final String toursCount ="tours_count";

    @Override
    public SaleEntity getSaleByIdUser(int userId) throws DAOException {
        SaleEntity userSale = null;

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(getSaleByIdUserQuery);
            ps.setInt(1, userId);

            res = ps.executeQuery();

            while (res.next()){
                int gettingId  = res.getInt(id);
                int gettingUserSale = res.getInt(idUser);
                int gettingSale = res.getInt(sale);
                int gettingCount = res.getInt(toursCount);

                userSale = new SaleEntity(gettingId, gettingUserSale, gettingSale, gettingCount) ;

            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("UserDaoImpl (getSaleByIdUser) -> some problems with extracting user");

        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return userSale;
    }

    @Override
    public SaleEntity saveNewSaleInfo(int userId) throws DAOException {
        SaleEntity saleEntity = new SaleEntity();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(insertQuery);

            statement.setInt(1, userId);

            statement.executeUpdate();

            saleEntity = getSaleByIdUser(userId);
        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("UserDaoImpl (addUser) -> some problems with extracting user");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }

        return saleEntity;
    }

    @Override
    public SaleEntity updateSaleInfo(int userId, int sale) throws DAOException {
        SaleEntity saleEntity = new SaleEntity();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(updateSaleQuery);

            statement.setInt(1, sale);
            statement.setInt(2, userId);

            statement.executeUpdate();

            saleEntity = getSaleByIdUser(userId);

        } catch (SQLException | ConnectionPoolException e){
            e.printStackTrace();
            LOGGER.error("SaleEntity (updateSaleInfo) -> some problems with extracting user");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }

        return saleEntity;
    }

    @Override
    public SaleEntity updateToursCount(int userId, int countOfTour) throws DAOException {
        SaleEntity saleEntity = new SaleEntity();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(updateCountQuery);

            statement.setInt(1, countOfTour);
            statement.setInt(2, userId);

            statement.executeUpdate();

            saleEntity = getSaleByIdUser(userId);

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("SaleEntity (updateSaleInfo) -> some problems with extracting user");
            e.printStackTrace();
        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }

        return saleEntity;
    }
}

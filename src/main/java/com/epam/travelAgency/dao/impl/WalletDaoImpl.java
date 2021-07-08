package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.WalletDao;
import com.epam.travelAgency.dao.pool.ConnectionPool;
import com.epam.travelAgency.dao.pool.ConnectionPoolException;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.UserRole;
import com.epam.travelAgency.entity.WalletEntity;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WalletDaoImpl implements WalletDao {
    private final Logger LOGGER = Logger.getLogger(WalletDaoImpl.class);

    private final String queryForGetAllWallets = "select * from wallet";
    private final String insertQuery = "insert into wallet (user_id) values(?) ";
    private final String deleteQuery = "delete from wallet where id = ";
    private final String findWallet = "select * from wallet where id = '" ;
    private final String findWalletByUserId = "select * from wallet, user where wallet.user_id = user.id and" +
            " user_id = '" ;

    private final String updateQuery = "update wallet set balance = ? where id = ?";

    private final String quote ="'";
    private final String idS ="id";
    private final String balanceS ="balance";
    private final String userIdS ="user_id";


    @Override
    public List<WalletEntity> getAllWallets() throws DAOException {
        List<WalletEntity> wallets = new ArrayList<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(queryForGetAllWallets);
            res = ps.executeQuery();

            while (res.next()){
                WalletEntity wallet = new WalletEntity();
                wallet.setId(Integer.parseInt(res.getString(idS)));
                wallet.setBalance(Double.parseDouble(res.getString(balanceS)));

                wallets.add(wallet);
            }
        } catch (ConnectionPoolException | SQLException e){
           LOGGER.error("WalletDaoImpl (getAllWallets) -> some problems with extracting wallets");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return wallets;
    }

    @Override
    public WalletEntity saveNewWallet(int userId) throws DAOException {
        WalletEntity newWallet = null;

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(insertQuery);

            statement.setInt(1, userId);

            statement.executeUpdate();

            newWallet = getWalletByUserId(userId);

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("WalletDaoImpl (save new Wallet) -> some problems with saving wallet");

        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }

        return newWallet;
    }

    @Override
    public WalletEntity getWalletById(int id) throws DAOException {
        WalletEntity wallet = new WalletEntity();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(findWallet + id);
            res = ps.executeQuery();

            while (res.next()){
                wallet.setId(Integer.parseInt(res.getString(idS)));
                wallet.setBalance(Double.parseDouble(res.getString(balanceS)));

            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("WalletDaoImpl (getWalletById) -> some problems with extracting wallet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return wallet;
    }

    @Override
    public WalletEntity getWalletByUserId(int userId) throws DAOException {
        WalletEntity wallet = new WalletEntity();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(findWalletByUserId + userId + quote);
            res = ps.executeQuery();

            while (res.next()){
                wallet.setId(Integer.parseInt(res.getString(idS)));
                wallet.setBalance(Double.parseDouble(res.getString(balanceS)));
                wallet.setUserId(Integer.parseInt(res.getString(userIdS)));
            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("WalletDaoImpl (getWalletById) -> some problems with extracting wallet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return wallet;
    }

    @Override
    public boolean updateBalance(int id, double newBalance) throws DAOException {
        boolean isUpdated = false;

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(updateQuery);

            ps.setDouble(1, newBalance);
            ps.setInt(2, id);

            ps.executeUpdate();

            isUpdated = true;

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("WalletDaoImpl (updateBalance) -> some problems with updating wallet");
            e.printStackTrace();
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps);
            }
        }

        return isUpdated;
    }

    @Override
    public boolean deleteWallet(int id) throws DAOException {
        boolean isDeleted = false;

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            statement = connection.prepareStatement(deleteQuery + id);
            statement.executeUpdate();

            isDeleted = true;

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("WalletDaoImpl (deleteWallet) -> some problems with deleting wallet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }

        return isDeleted;
    }
}

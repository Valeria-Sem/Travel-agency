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
    private final String insertQuery = "insert into wallet (balance) values(?) ";
    private final String deleteQuery = "delete from wallet where id = ";
    private final String findWallet = "select * from wallet where id = '" ;
    private final String updateQuery1 = "update wallet set balance ='" ;
    private final String updateQuery2 = "' where id = " ;


    @Override
    public List<WalletEntity> getAllWallets() throws DAOException {
        List<WalletEntity> wallets = new ArrayList<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(queryForGetAllWallets);
            ResultSet res = ps.executeQuery();

            while (res.next()){
                WalletEntity wallet = new WalletEntity();
                wallet.setId(Integer.parseInt(res.getString("id")));
                wallet.setBalance(Double.parseDouble(res.getString("balance")));

                wallets.add(wallet);
            }
        } catch (ConnectionPoolException | SQLException e){
           LOGGER.error("WalletDaoImpl (getAllWallets) -> some problems with extracting wallets");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps);
            }
        }

        return wallets;
    }

    @Override
    public boolean addWallet(WalletEntity walletEntity) throws DAOException {
        boolean isAdded = false;
        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(insertQuery);

            statement.setDouble(1, walletEntity.getBalance());

            statement.executeUpdate();

            isAdded = true;

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("WalletDaoImpl (addWallet) -> some problems with adding wallet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }

        return isAdded;
    }

    @Override
    public WalletEntity getWalletById(int id) throws DAOException {
        WalletEntity wallet = new WalletEntity();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(findWallet + id);
            ResultSet res = ps.executeQuery();

            while (res.next()){
                wallet.setId(Integer.parseInt(res.getString("id")));
                wallet.setBalance(Double.parseDouble(res.getString("balance")));

            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("WalletDaoImpl (getWalletById) -> some problems with extracting wallet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps);
            }
        }

        return wallet;
    }

    @Override
    public boolean updateBalance(int id, double newBalance) throws DAOException {
        boolean isUpdated = false;

        Connection connection = null;
        ConnectionPool pool = null;
        Statement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            statement = connection.createStatement();
            statement.executeUpdate(updateQuery1 + newBalance + updateQuery2 + id);

            isUpdated = true;

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("WalletDaoImpl (updateBalance) -> some problems with updating wallet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }

        return isUpdated;
    }

    @Override
    public boolean deleteWallet(int id) throws DAOException {
        boolean isDeleted = false;

        Connection connection = null;
        ConnectionPool pool = null;
        Statement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            statement = connection.createStatement();
            statement.executeUpdate(deleteQuery + id);

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

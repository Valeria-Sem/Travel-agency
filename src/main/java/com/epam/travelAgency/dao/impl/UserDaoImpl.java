package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.UserDAO;
import com.epam.travelAgency.dao.pool.ConnectionPool;
import com.epam.travelAgency.dao.pool.ConnectionPoolException;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.UserRole;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDAO {
    private final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    private final String queryForGetAllUsers = "select * from user";
    private final String insertQuery = "insert into user (email, password, role) values(?, ?, ?) ";
    private final String deleteQuery = "delete from user where id = ";
    private final String loginQueryByEmail = "select * from user where email = '" ;
    private final String loginQueryByPassword ="' and password = '";
    private final String updateQuery ="UPDATE user SET email = ?, password = ? WHERE id = ?";
    private final String i ="'";
    private final String GET_ALL_CUSTOMERS_QUERY = "select * from user where role = ?";

    private final String id ="id";
    private final String email ="email";
    private final String password ="password";
    private final String role ="role";

    @Override
    public List<UserEntity> getAllUsers() throws DAOException {
        List<UserEntity> users = new ArrayList<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(queryForGetAllUsers);
            res = ps.executeQuery();

            while (res.next()){
                UserEntity user = new UserEntity();
                user.setId(Integer.parseInt(res.getString(id)));
                user.setEmail(res.getString(email));
                user.setPassword(res.getString(password));
                user.setRole(UserRole.valueOf(res.getString(role)));

                users.add(user);
            }
        } catch (ConnectionPoolException | SQLException e){
           LOGGER.error("UserDaoImpl (getAllUsers) -> some problems with extracting users");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return users;
    }

    @Override
    public List<UserEntity> getAllCustomers() throws DAOException {
        List<UserEntity> users = new ArrayList<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(GET_ALL_CUSTOMERS_QUERY);
            ps.setString(1, String.valueOf(UserRole.CUSTOMER));
            res = ps.executeQuery();

            while (res.next()){
                UserEntity user = new UserEntity();
                user.setId(Integer.parseInt(res.getString(id)));
                user.setEmail(res.getString(email));
                user.setPassword(res.getString(password));
                user.setRole(UserRole.valueOf(res.getString(role)));

                users.add(user);
            }
        } catch (ConnectionPoolException | SQLException e){
            LOGGER.error("UserDaoImpl (getAllUsers) -> some problems with extracting users");
            throw new DAOException(e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return users;
    }

    @Override
    public boolean addUser(UserEntity userEntity) throws DAOException{
        boolean isAdded = false;
        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(insertQuery);

            statement.setString(1, userEntity.getEmail());
            statement.setString(2, userEntity.getPassword());
            statement.setString(3, userEntity.getRole().name());

            statement.executeUpdate();

            isAdded = true;

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("UserDaoImpl (addUser) -> some problems with extracting user");
            throw new DAOException(e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }

        return isAdded;
    }

    @Override
    public UserEntity getUserByEmailAndPassword(String userEmail, String userPassword) throws DAOException{
        UserEntity user = null;

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(loginQueryByEmail + userEmail + loginQueryByPassword + userPassword + "'");
            res = ps.executeQuery();

            while (res.next()){
                user = new UserEntity(res.getInt(id), res.getString(email), res.getString(password),
                        UserRole.valueOf(res.getString(role)));
//                user.setId(res.getInt(id));
//                user.setEmail(res.getString(email));
//                user.setPassword(res.getString(password));
//                user.setRole(UserRole.valueOf(res.getString(role)));

            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("UserDaoImpl (getUserByEmailAndPassword) -> some problems with extracting user");
            throw new DAOException(e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return user;
    }

    @Override
    public boolean isUserUpdate(UserEntity userEntity, String newEmail, String newPassword) throws DAOException {
        boolean isUserUpdate;
        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(updateQuery);

            statement.setString(1, newEmail);
            statement.setString(2, newPassword);
            statement.setInt(3, userEntity.getId());

            statement.executeUpdate();
            statement.close();

            isUserUpdate = true;

        } catch (SQLException | ConnectionPoolException e){
            e.printStackTrace();
            LOGGER.error("UserDaoImpl (isUserByEmail) -> some problems with extracting user");
            throw new DAOException(e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }

        return isUserUpdate;
    }

    @Override
    public boolean isUserByEmail(String email) throws DAOException {
        boolean isFind = false;
        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(loginQueryByEmail + email + i);
            res = statement.executeQuery();

            if (res.next()){
                isFind = true;
            }

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("UserDaoImpl (isUserByEmail) -> some problems with extracting user");
            throw new DAOException(e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement, res);
            }
        }

        return isFind;
    }

    @Override
    public void deleteUser(int id) throws DAOException {
        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            statement = connection.prepareStatement(deleteQuery + id);
            statement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("UserDaoImpl (deleteUser) -> some problems with deleting user");
            throw new DAOException(e);

        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }
    }
}

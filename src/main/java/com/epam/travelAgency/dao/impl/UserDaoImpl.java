package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.UserDao;
import com.epam.travelAgency.dao.pool.ConnectionPool;
import com.epam.travelAgency.dao.pool.ConnectionPoolException;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.UserRole;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class UserDaoImpl implements UserDao {
    private final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    private final String queryForGetAllUsers = "select * from user";
    private final String insertQuery = "insert into user (email, password, role) values(?, ?, ?) ";
    private final String deleteQuery = "delete from user where id = ";
    private final String loginQueryByEmail = "select * from user where email = '" ;
    private final String loginQueryByPassword ="' and password = '";
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

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(queryForGetAllUsers);
            ResultSet res = ps.executeQuery();

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
                pool.closeConnection(connection, ps);
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
        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }

        return isAdded;
    }

    @Override
    public Optional<UserEntity> getUserByEmailAndPassword(String userEmail, String userPassword) throws DAOException{
        Optional<UserEntity> user = Optional.empty();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(loginQueryByEmail + userEmail + loginQueryByPassword + userPassword + "'");
            ResultSet res = ps.executeQuery();

            while (res.next()){
                int userId  = res.getInt(id);
                String userEm = res.getString(email);
                String userPass = res.getString(password);
                UserRole userRole = UserRole.valueOf(res.getString(role));

                user = Optional.of(new UserEntity(userId, userEm, userPass, userRole));

            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("UserDaoImpl (getUserByEmailAndPassword) -> some problems with extracting user");

        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps);
            }
        }

        return user;
    }

    @Override
    public boolean deleteUser(int id) throws DAOException {
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
            LOGGER.error("UserDaoImpl (deleteUser) -> some problems with deleting user");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }

        return isDeleted;
    }
}

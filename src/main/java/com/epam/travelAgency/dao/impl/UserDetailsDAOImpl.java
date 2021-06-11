package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.UserDetailsDAO;
import com.epam.travelAgency.dao.pool.ConnectionPool;
import com.epam.travelAgency.dao.pool.ConnectionPoolException;
import com.epam.travelAgency.entity.UserDetailsEntity;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDetailsDAOImpl implements UserDetailsDAO {
    private final Logger LOGGER = Logger.getLogger(UserDetailsDAOImpl.class);

    private final String queryForGetAllUsersDet = "select * from user_details";
    private final String insertQuery = "insert into user_details (id_user, name, surname, date_of_birth," +
            " citizenship, passport, date_of_issue, expiration_date, id_wallet) values(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private final String deleteQuery = "delete from user_details where id = ";
    private final String searchUserDetails = "select * from user_details where id_user = '" ;
    private final String id = "id" ;
    private final String idUser = "id_user" ;
    private final String name = "name" ;
    private final String surname = "surname" ;
    private final String dateOfBirth = "date_of_birth" ;
    private final String citizenship = "citizenship" ;
    private final String passport = "passport" ;
    private final String dateOfIssue = "date_of_issue" ;
    private final String expirationDate = "expiration_date" ;
    private final String idWallet = "id_wallet" ;


    @Override
    public List<UserDetailsEntity> getAllUserDetails() throws DAOException{
        List<UserDetailsEntity> details = new ArrayList<>();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(queryForGetAllUsersDet);
            ResultSet res = ps.executeQuery();

            while (res.next()){
                UserDetailsEntity userDetails = new UserDetailsEntity();
                userDetails.setId(Integer.parseInt(res.getString(id)));
                userDetails.setIdUser(Integer.parseInt(res.getString(idUser)));
                userDetails.setName(res.getString(name));
                userDetails.setSurname(res.getString(surname));
                userDetails.setDateOfBirth(LocalDate.parse(res.getString(dateOfBirth)));
                userDetails.setCitizenship(res.getString(citizenship));
                userDetails.setPassport(res.getString(passport));
                userDetails.setDateOfIssue(LocalDate.parse(res.getString(dateOfIssue)));
                userDetails.setExpirationDate(LocalDate.parse(res.getString(expirationDate)));
                userDetails.setIdWallet(Integer.parseInt(res.getString(idWallet)));

                details.add(userDetails);
            }
        } catch (ConnectionPoolException | SQLException e){
            LOGGER.error("UserDetailsDAOImpl (getAllUserDetails) -> some problems with extracting userDet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps);
            }
        }

        return details;
    }

    @Override
    public boolean addUserDetails(UserDetailsEntity userDetails) throws DAOException{
        boolean isAdded = false;
        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement statement = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();

            statement = connection.prepareStatement(insertQuery);

            statement.setInt(1, userDetails.getIdUser());
            statement.setString(2, userDetails.getName());
            statement.setString(3, userDetails.getSurname());
            statement.setDate(4, Date.valueOf(userDetails.getDateOfBirth()));
            statement.setString(5, userDetails.getCitizenship());
            statement.setString(6, userDetails.getPassport());
            statement.setDate(7, Date.valueOf(userDetails.getDateOfIssue()));
            statement.setDate(8, Date.valueOf(userDetails.getExpirationDate()));
            statement.setInt(9, userDetails.getIdWallet());

            statement.executeUpdate();

            isAdded = true;

        } catch (SQLException | ConnectionPoolException e){
            LOGGER.error("UserDetailsDAOImpl (addUserDetails) -> some problems with adding userDet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }

        return isAdded;
    }

    @Override
    public UserDetailsEntity getUserDetailsByUserId(int id) throws DAOException{
        UserDetailsEntity userDetails = new UserDetailsEntity();

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(searchUserDetails + id);
            ResultSet res = ps.executeQuery();

            while (res.next()){
                userDetails.setId(Integer.parseInt(res.getString(id)));
                userDetails.setIdUser(Integer.parseInt(res.getString(idUser)));
                userDetails.setName(res.getString(name));
                userDetails.setSurname(res.getString(surname));
                userDetails.setDateOfBirth(LocalDate.parse(res.getString(dateOfBirth)));
                userDetails.setCitizenship(res.getString(citizenship));
                userDetails.setPassport(res.getString(passport));
                userDetails.setDateOfIssue(LocalDate.parse(res.getString(dateOfIssue)));
                userDetails.setExpirationDate(LocalDate.parse(res.getString(expirationDate)));
                userDetails.setIdWallet(Integer.parseInt(res.getString(idWallet)));

            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("UserDetailsDAOImpl (getUserDetailsByUserId) -> some problems with getting userDet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps);
            }
        }

        return userDetails;
    }

    @Override
    public boolean deleteUserDetails(int id) throws DAOException{
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
            LOGGER.error("UserDetailsDAOImpl (deleteUserDetails) -> some problems with deleting userDet");
        } finally {
            if(connection != null){
                pool.closeConnection(connection, statement);
            }
        }

        return isDeleted;
    }
}

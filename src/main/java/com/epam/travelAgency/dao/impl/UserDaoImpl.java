package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.UserDao;
import com.epam.travelAgency.dao.pool.ConnectionPool;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.enums.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserDaoImpl implements UserDao {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
    private static final String dbUrl = resourceBundle.getString("dbUrl");
    private static final String dbUser = resourceBundle.getString("dbUser");
    private static final String dbPassword = resourceBundle.getString("dbPassword");

    private Connection conn = null;
    private static final ConnectionPool pool = new ConnectionPool(dbUrl, dbUser, dbPassword, 4);

    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = new ArrayList<>();
        UserEntity user = new UserEntity();
        try{
            conn = pool.getConnection();
            try(Statement statement = conn.createStatement()){
                ResultSet res = statement.executeQuery("select * from user");
                while (res.next()){
                    user.setId(Integer.parseInt(res.getString("id")));
                    user.setEmail(res.getString("email"));
                    user.setPassword(res.getString("password"));
                    user.setRole(UserRole.valueOf(res.getString("role")));

                    users.add(user);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(conn != null){
                try{
                    pool.returnConnection(conn);
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

        return users;
    }

    @Override
    public void addUser(UserEntity userEntity) {
        String insertQuery = "insert into user (email, password, role) values(?, ?, ?) ";
        try{
            conn = pool.getConnection();
           // try{
                PreparedStatement statement = conn.prepareStatement(insertQuery);

                statement.setString(1, userEntity.getEmail());
                statement.setString(2, userEntity.getPassword());
                statement.setString(3, userEntity.getRole().name());

                statement.executeUpdate();
           // }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(conn != null){
                try{
                    pool.returnConnection(conn);
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public UserEntity getUserByEmailAndPassword(String email, String password) {
        UserEntity user = new UserEntity();
        try{
            conn = pool.getConnection();
            try(Statement statement = conn.createStatement()){
                ResultSet res = statement.executeQuery("select * from user where email = " + email +" and password = " + password);
                while (res.next()){
                    user.setId(Integer.parseInt(res.getString("id")));
                    user.setEmail(res.getString("email"));
                    user.setPassword(res.getString("password"));
                    user.setRole(UserRole.valueOf(res.getString("role")));

                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(conn != null){
                try{
                    pool.returnConnection(conn);
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

        return user;
    }

    @Override
    public void deleteUser(int id) {
        try{
            conn = pool.getConnection();
            try(Statement statement = conn.createStatement()){
               statement.executeUpdate("delete from user where id = " + id);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(conn != null){
                try{
                    pool.returnConnection(conn);
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

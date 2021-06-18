package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<UserEntity> getAllUsers() throws DAOException;
    boolean addUser(UserEntity userEntity) throws DAOException;
    Optional<UserEntity> getUserByEmailAndPassword(String email, String password) throws DAOException;
    boolean isUserByEmail(String email) throws DAOException;
    boolean deleteUser(int id) throws DAOException;
}

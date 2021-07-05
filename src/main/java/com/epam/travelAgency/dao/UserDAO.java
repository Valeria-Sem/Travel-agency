package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<UserEntity> getAllUsers() throws DAOException;
    boolean addUser(UserEntity userEntity) throws DAOException;
    UserEntity getUserByEmailAndPassword(String email, String password) throws DAOException;
    boolean isUserUpdate(UserEntity userEntity, String newEmail, String newPassword) throws DAOException;
    boolean isUserByEmail(String email) throws DAOException;
    boolean deleteUser(int id) throws DAOException;

}

package com.epam.travelAgency.service;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> getAllUsers() throws ServiceException;
    boolean addUser(UserEntity userEntity) throws ServiceException;
    UserEntity getUserByEmailAndPassword(String email, String password) throws ServiceException;
    boolean deleteUser(int id) throws ServiceException;
    boolean isUserByEmail (String email) throws ServiceException;
    boolean isUserUpdate(UserEntity userEntity, String newEmail, String newPassword) throws ServiceException;
    List<UserEntity> getAllCustomers() throws ServiceException;
}

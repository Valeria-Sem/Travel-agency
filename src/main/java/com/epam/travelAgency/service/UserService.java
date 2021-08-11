package com.epam.travelAgency.service;

import com.epam.travelAgency.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers() throws ServiceException;
    boolean addUser(UserEntity userEntity) throws ServiceException;
    UserEntity getUserByEmailAndPassword(String email, String password) throws ServiceException;
    void deleteUser(int id) throws ServiceException;
    boolean isUserByEmail (String email) throws ServiceException;
    boolean isUserUpdate(UserEntity userEntity, String newEmail, String newPassword) throws ServiceException;
    List<UserEntity> getAllCustomers() throws ServiceException;
}

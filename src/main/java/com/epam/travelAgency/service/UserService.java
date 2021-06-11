package com.epam.travelAgency.service;

import com.epam.travelAgency.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> getAllUsers() throws ServiceException;
    boolean addUser(UserEntity userEntity) throws ServiceException;
    Optional<UserEntity> getUserByEmailAndPassword(String email, String password) throws ServiceException;
    boolean deleteUser(int id) throws ServiceException;
}

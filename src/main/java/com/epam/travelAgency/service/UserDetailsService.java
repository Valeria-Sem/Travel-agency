package com.epam.travelAgency.service;

import com.epam.travelAgency.entity.UserDetailsEntity;
import com.epam.travelAgency.entity.UserEntity;

import java.util.List;

public interface UserDetailsService {
    List<UserDetailsEntity> getAllUsersDetails() throws ServiceException;
    boolean addUserDetails(UserDetailsEntity userEntity) throws ServiceException;
    UserDetailsEntity getUserDetailsByIdUser(int id) throws ServiceException;
    boolean deleteUserDetails(int id) throws ServiceException;
}

package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.UserDetailsEntity;
import com.epam.travelAgency.entity.UserEntity;

import java.util.List;

public interface UserDetailsDAO {
    List<UserDetailsEntity> getAllUserDetails() throws DAOException;
    boolean addUserDetails(UserDetailsEntity userDetails) throws DAOException;
    UserDetailsEntity getUserDetailsByUserId(int id) throws DAOException;
    boolean deleteUserDetails(int id) throws DAOException;
}

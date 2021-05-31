package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.UserEntity;

import java.util.List;

public interface UserDao {
    List<UserEntity> getAllUsers();
    void addUser(UserEntity userEntity);
    UserEntity getUserByEmailAndPassword(String email, String password);
    void deleteUser(int id);
}

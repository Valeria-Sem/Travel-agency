package com.epam.travelAgency.service.imp;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.dao.UserDao;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Override
    public List<UserEntity> getAllUsers() throws ServiceException {
        List<UserEntity> users;

        DAOProvider provider = DAOProvider.getInstance();
        UserDao userDao = provider.getUserDAO();

        try{
            users = userDao.getAllUsers();
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return users;
    }

    @Override
    public boolean addUser(UserEntity userEntity) throws ServiceException {
        boolean isAdded = false;

        DAOProvider provider = DAOProvider.getInstance();
        UserDao userDao = provider.getUserDAO();

        try{
            isAdded = userDao.addUser(userEntity);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isAdded;
    }

    @Override
    public Optional<UserEntity> getUserByEmailAndPassword(String email, String password) throws ServiceException {
        Optional<UserEntity> user;

        DAOProvider provider = DAOProvider.getInstance();
        UserDao userDao = provider.getUserDAO();

        try{
            user = userDao.getUserByEmailAndPassword(email,password);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return user;
    }

    @Override
    public boolean deleteUser(int id) throws ServiceException {
        boolean isDeleted = false;

        DAOProvider provider = DAOProvider.getInstance();
        UserDao userDao = provider.getUserDAO();

        try{
            isDeleted = userDao.deleteUser(id);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isDeleted;
    }
}

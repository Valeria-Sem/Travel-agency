package com.epam.travelAgency.service.imp;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.dao.UserDAO;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<UserEntity> getAllUsers() throws ServiceException {
        List<UserEntity> users;

        DAOProvider provider = DAOProvider.getInstance();
        UserDAO userDao = provider.getUserDAO();

        try{
            users = userDao.getAllUsers();
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return users;
    }

    @Override
    public boolean addUser(UserEntity userEntity) throws ServiceException {
        boolean isAdded;

        DAOProvider provider = DAOProvider.getInstance();
        UserDAO userDao = provider.getUserDAO();

        try{
            isAdded = userDao.addUser(userEntity);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isAdded;
    }

    @Override
    public UserEntity getUserByEmailAndPassword(String email, String password) throws ServiceException {
        UserEntity user;

        DAOProvider provider = DAOProvider.getInstance();
        UserDAO userDao = provider.getUserDAO();

        try{
            user = userDao.getUserByEmailAndPassword(email,password);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return user;
    }

    @Override
    public void deleteUser(int id) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        UserDAO userDao = provider.getUserDAO();

        try{
            userDao.deleteUser(id);
        } catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean isUserByEmail(String email) throws ServiceException{
        boolean isFind;

        DAOProvider provider = DAOProvider.getInstance();
        UserDAO userDao = provider.getUserDAO();

        try{
            isFind = userDao.isUserByEmail(email);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isFind;
    }

    @Override
    public boolean isUserUpdate(UserEntity userEntity, String newEmail, String newPassword) throws ServiceException {
        boolean isUserUpdate;

        DAOProvider provider = DAOProvider.getInstance();
        UserDAO userDao = provider.getUserDAO();

        try{
            isUserUpdate = userDao.isUserUpdate(userEntity, newEmail, newPassword);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isUserUpdate;
    }

    @Override
    public List<UserEntity> getAllCustomers() throws ServiceException {
        List<UserEntity> users;

        DAOProvider provider = DAOProvider.getInstance();
        UserDAO userDao = provider.getUserDAO();

        try{
            users = userDao.getAllCustomers();
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return users;
    }


}

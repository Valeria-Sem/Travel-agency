package com.epam.travelAgency.dao;

import com.epam.travelAgency.dao.impl.CategoryDaoImpl;
import com.epam.travelAgency.dao.impl.UserDaoImpl;
import com.epam.travelAgency.dao.impl.UserDetailsDAOImpl;
import com.epam.travelAgency.dao.impl.WalletDaoImpl;

public class DAOProvider {

    private static final DAOProvider instance = new DAOProvider();

    private final UserDao userDAO = new UserDaoImpl();
    private final UserDetailsDAO userDetailsDAO = new UserDetailsDAOImpl();
    private final WalletDao walletDAO = new WalletDaoImpl();
    private final CategoryDAO categoryDAO = new CategoryDaoImpl();


    private DAOProvider(){}

    public static DAOProvider getInstance(){
        return instance;
    }

    public UserDao getUserDAO(){
        return userDAO;
    }

    public UserDetailsDAO getUserDetailsDAO(){
        return userDetailsDAO;
    }

    public WalletDao getWalletDAO(){
        return walletDAO;
    }

    public CategoryDAO getCategoryDAO(){
        return categoryDAO;
    }
}

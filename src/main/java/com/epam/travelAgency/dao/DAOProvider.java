package com.epam.travelAgency.dao;

import com.epam.travelAgency.dao.impl.*;

public class DAOProvider {

    private static final DAOProvider instance = new DAOProvider();

    private final UserDAO userDAO = new UserDaoImpl();
    private final UserDetailsDAO userDetailsDAO = new UserDetailsDAOImpl();
    private final WalletDao walletDAO = new WalletDaoImpl();
    private final CategoryDAO categoryDAO = new CategoryDaoImpl();
    private final CountriesDAO countriesDAO = new CountriesDaoImp();
    private final DateDAO dateDAO = new DateDaoImpl();
    private final DateTourDAO dateTourDAO = new DateTourDaoImpl();
    private final TourDAO tourDAO = new TourDaoImpl();
    private final MealsDAO mealsDAO = new MealsDaoImpl();
    private final SaleDAO saleDAO = new SaleDaoImpl();
    private final TourCustomerDAO tourCustomerDAO = new TourCustomerDaoImpl();
    private final HotelDAO hotelDAO = new HotelDaoImpl();
    private final TransportDAO transportDAO = new TransportDaoImpl();

    private DAOProvider(){}

    public static DAOProvider getInstance(){
        return instance;
    }

    public UserDAO getUserDAO(){
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

    public CountriesDAO getCountriesDAO() {
        return countriesDAO;
    }

    public DateDAO getDateDAO() {
        return dateDAO;
    }

    public DateTourDAO getDateTourDAO() {
        return dateTourDAO;
    }

    public TourDAO getTourDAO() {
        return tourDAO;
    }

    public MealsDAO getMealsDAO() {
        return mealsDAO;
    }

    public SaleDAO getSaleDAO() {
        return saleDAO;
    }

    public TourCustomerDAO getTourCustomerDAO() {
        return tourCustomerDAO;
    }

    public HotelDAO getHotelDAO() {
        return hotelDAO;
    }

    public TransportDAO getTransportDAO() {
        return transportDAO;
    }
}

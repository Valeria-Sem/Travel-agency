package com.epam.travelAgency.service;

import com.epam.travelAgency.service.imp.CategoryServiceImpl;
import com.epam.travelAgency.service.imp.UserDetailsServiceImpl;
import com.epam.travelAgency.service.imp.UserServiceImpl;
import com.epam.travelAgency.service.imp.WalletServiceImpl;

public class ServiceProvider {

    private static final ServiceProvider instance = new ServiceProvider();

    private final UserService userService = new UserServiceImpl();
    private final UserDetailsService userDetailsService = new UserDetailsServiceImpl();
    private final WalletService walletService = new WalletServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();

    private ServiceProvider() {}


    public static ServiceProvider getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public WalletService getWalletService() {
        return walletService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }
}

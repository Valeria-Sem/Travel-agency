package com.epam.travelAgency.service;

import com.epam.travelAgency.service.imp.*;
import com.epam.travelAgency.service.validation.ValidationService;
import com.epam.travelAgency.service.validation.impl.ValidationImpl;

public class ServiceProvider {

    private static final ServiceProvider instance = new ServiceProvider();

    private final UserService userService = new UserServiceImpl();
    private final UserDetailsService userDetailsService = new UserDetailsServiceImpl();
    private final WalletService walletService = new WalletServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();
    private final CountriesService countriesService = new CountriesServiceImpl();
    private final HotelService hotelService = new HotelServiceImpl();
    private final MealsService mealsService = new MealsServiceImpl();
    private final DateTourService dateTourService = new DateTourServiceImpl();
    private final DateService dateService = new DateServiceImpl();
    private final TourService tourService = new TourServiceImpl();
    private final TourCustomerService tourCustomerService = new TourCustomerServiceImpl();
    private final SaleService saleService = new SaleServiceImpl();
    private final TransportService transportService = new TransportServiceImpl();
    private final ValidationService validationService = new ValidationImpl();


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

    public CountriesService getCountriesService() {
        return countriesService;
    }

    public HotelService getHotelService() {
        return hotelService;
    }

    public MealsService getMealsService() {
        return mealsService;
    }

    public DateTourService getDateTourService() {
        return dateTourService;
    }

    public DateService getDateService() {
        return dateService;
    }

    public TourService getTourService() {
        return tourService;
    }

    public TourCustomerService getTourCustomerService() {
        return tourCustomerService;
    }

    public SaleService getSaleService() {
        return saleService;
    }

    public TransportService getTransportService() {
        return transportService;
    }

    public ValidationService getValidationService() {
        return validationService;
    }
}

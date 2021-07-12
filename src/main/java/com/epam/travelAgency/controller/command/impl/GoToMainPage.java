package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.dao.CountriesDAO;
import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.TourDAO;
import com.epam.travelAgency.dao.impl.CountriesDaoImp;
import com.epam.travelAgency.dao.impl.TourDaoImpl;
import com.epam.travelAgency.entity.CategoryEntity;
import com.epam.travelAgency.entity.CountriesEntity;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.TourStatus;
import com.epam.travelAgency.service.*;
import com.epam.travelAgency.service.validation.impl.ValidationImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToMainPage implements Command {
    private final Logger LOGGER = Logger.getLogger(GoToMainPage.class);

    private final String PATH_TO_MAIN_PAGE = "WEB-INF/jsp/main/mainPage.jsp";
    private final String HOT_TOURS = "hotTours";
    private final String COUNTRIES = "countries";
    private final String PAGE = "page";
    private final String PAGE_COMMAND = "gotomainpage";
    private final String ERROR_ATTRIBUTE = "errorMsg";
    private final String SERVER_ERROR= "Sorry, server error.";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";

    public GoToMainPage(){

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<TourEntity> hotTours = (List<TourEntity>) session.getAttribute(HOT_TOURS);
        List<CountriesEntity> countries = (List<CountriesEntity>) session.getAttribute(COUNTRIES);

        if(hotTours == null && countries == null){

            ServiceProvider provider = ServiceProvider.getInstance();
            TourService tourService = provider.getTourService();
            CountriesService countriesService = provider.getCountriesService();

            try {
                hotTours = tourService.getTourByStatus(TourStatus.HOT);
                countries = countriesService.getAllCountries();

                session.setAttribute(HOT_TOURS, hotTours);
                session.setAttribute(COUNTRIES, countries);

            } catch (ServiceException e) {
                LOGGER.error(SERVER_ERROR, e);

                request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR);
                RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_ERROR_PAGE);
                dispatcher.forward(request, response);
            }
        }

        session.setAttribute(PAGE, PAGE_COMMAND);

        RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_MAIN_PAGE);
        dispatcher.forward(request, response);

    }
}

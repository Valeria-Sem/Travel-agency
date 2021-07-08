package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.dao.CountriesDAO;
import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.TourDAO;
import com.epam.travelAgency.dao.impl.CountriesDaoImp;
import com.epam.travelAgency.dao.impl.TourDaoImpl;
import com.epam.travelAgency.entity.*;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.ServiceProvider;
import com.epam.travelAgency.service.TourService;
import com.epam.travelAgency.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ShowChillToursData implements Command {
    private final Logger LOGGER = Logger.getLogger(ShowChillToursData.class);

    private final String pathToChillPage = "controller?command=gotochillpage";
    private final String countryS = "countries";
    private final String category = "Отпуск";
    private final String adultsS = "adults";
    private final String childrenS = "children";
    private final String arrDateS = "arrivalDate";
    private final String depDateS = "departureDate";
    private final String chillToursS = "chillTours";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";

    private final String errorMessage = "errorMsg";
    private final String SERVER_ERROR= "Sorry server error.";


    public ShowChillToursData() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);

        String country;
        int adults;
        int children;
        LocalDate arrDate;
        LocalDate depDate;
        Set<TourEntity> chillTours;

        try {
            country = request.getParameter(countryS);
            adults = Integer.parseInt(request.getParameter(adultsS));
            children = Integer.parseInt(request.getParameter(childrenS));
            arrDate = LocalDate.parse(request.getParameter(arrDateS));
            depDate = LocalDate.parse(request.getParameter(depDateS));

            ServiceProvider serviceProvider = ServiceProvider.getInstance();
            TourService tourService = serviceProvider.getTourService();

            chillTours = tourService.getTourByStartParams(category, country, arrDate, depDate, adults, children);

            session.setAttribute(chillToursS, chillTours);

            response.sendRedirect(pathToChillPage);

        } catch (ServiceException e) {
            LOGGER.error(SERVER_ERROR, e);

            request.setAttribute(errorMessage, SERVER_ERROR);
            request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
        }
    }
}

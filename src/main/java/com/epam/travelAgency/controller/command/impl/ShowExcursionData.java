package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.TourDAO;
import com.epam.travelAgency.dao.impl.TourDaoImpl;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.ServiceProvider;
import com.epam.travelAgency.service.TourService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.ServerException;
import java.time.LocalDate;
import java.util.Set;

public class ShowExcursionData implements Command {
    private final Logger LOGGER = Logger.getLogger(ShowExcursionData.class);

    private final String pathToExcursionPage = "controller?command=gotoexcursionpage";
    private final String countryS = "countries";
    private final String category = "Экскурсии";
    private final String arrDateS = "arrivalDate";
    private final String depDateS = "departureDate";
    private final String excursionToursS = "excursionTours";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";

    private final String errorMessage = "errorMsg";
    private final String SERVER_ERROR= "Sorry server error.";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);

        String country;
        LocalDate arrDate;
        LocalDate depDate;
        Set<TourEntity> excursionTours ;

        ServiceProvider provider = ServiceProvider.getInstance();
        TourService tourService = provider.getTourService();

        try {
            country = request.getParameter(countryS);
            arrDate = LocalDate.parse(request.getParameter(arrDateS));
            depDate = LocalDate.parse(request.getParameter(depDateS));

            excursionTours = tourService.getTourByStartParams(category, country, arrDate, depDate);

            session.setAttribute(excursionToursS, excursionTours);

            response.sendRedirect(pathToExcursionPage);
        } catch (ServiceException e) {
            LOGGER.error(SERVER_ERROR, e);

            request.setAttribute(errorMessage, SERVER_ERROR);
            request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
        }
    }
}

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

    private final String GO_TO_EXCURSION_PAGE_COMMAND = "controller?command=gotoexcursionpage";
    private final String COUNTRY = "countries";
    private final String CATEGORY = "Экскурсии";
    private final String ARR_DATE = "arrivalDate";
    private final String DEP_DATE = "departureDate";
    private final String EXCURSION_TOURS = "excursionTours";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";

    private final String ERROR_ATTRIBUTE = "errorMsg";
    private final String SERVER_ERROR= "Sorry server error. Please, come back later.";

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
            country = request.getParameter(COUNTRY);
            arrDate = LocalDate.parse(request.getParameter(ARR_DATE));
            depDate = LocalDate.parse(request.getParameter(DEP_DATE));

            excursionTours = tourService.getTourByStartParams(CATEGORY, country, arrDate, depDate);

            session.setAttribute(EXCURSION_TOURS, excursionTours);

            response.sendRedirect(GO_TO_EXCURSION_PAGE_COMMAND);
        } catch (ServiceException e) {
            LOGGER.error(SERVER_ERROR, e);

            request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR);
            request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
        }
    }
}

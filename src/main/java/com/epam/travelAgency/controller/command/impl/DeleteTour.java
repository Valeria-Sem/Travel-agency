package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.ServiceProvider;
import com.epam.travelAgency.service.TourService;
import com.epam.travelAgency.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteTour implements Command {
    private final Logger LOGGER = Logger.getLogger(DeleteTour.class);

    private final String PATH_TO_ADMIN_PAGE = "controller?command=gotoadminpage";

    private final String TOUR_ID_PARAM = "id_tour";
    private final String CURRENT_USER = "current_user";
    private final String ERROR_ATTRIBUTE = "errorMsg";

    private final String SERVER_ERROR= "Sorry, login server error.";
    private final String ERROR_PAGE_PATH = "WEB-INF/jsp/error/errorPage.jsp";

    public DeleteTour(){

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession();

        int idTour;

        if (request.getParameter(TOUR_ID_PARAM) != null){
            try {
                idTour = Integer.parseInt(request.getParameter(TOUR_ID_PARAM));

                ServiceProvider serviceProvider = ServiceProvider.getInstance();
                TourService tourService = serviceProvider.getTourService();

                tourService.deleteTourById(idTour);

                response.sendRedirect(PATH_TO_ADMIN_PAGE);
            } catch (ServiceException e) {
                request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR);
                request.getRequestDispatcher(ERROR_PAGE_PATH).forward(request, response);

                LOGGER.error(SERVER_ERROR, e);
            }

        }
    }
}

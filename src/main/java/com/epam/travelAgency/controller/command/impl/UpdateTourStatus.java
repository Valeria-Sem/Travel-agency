package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.SaleEntity;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.TourStatus;
import com.epam.travelAgency.service.SaleService;
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

public class UpdateTourStatus implements Command {
    private final Logger LOGGER = Logger.getLogger(UpdateUserInfo.class);

    private final String TOUR_STATUS = "status";
    private final String errorMessageS = "errorMsg";
    private final String pathToAdminPage = "controller?command=gotoadminpage";
    private final String ID_TOUR = "id_tour";

    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";
    private final String SERVER_ERROR= "Sorry server error.";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TourStatus status;
        int tourId;

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        TourService tourService = serviceProvider.getTourService();

        try {
            tourId = Integer.parseInt(request.getParameter(ID_TOUR));
            status = TourStatus.valueOf(request.getParameter(TOUR_STATUS));

            tourService.isTourStatusUpdate(tourId, status);
            response.sendRedirect(pathToAdminPage);

        } catch (ServiceException e) {
            request.setAttribute(errorMessageS, SERVER_ERROR);
            LOGGER.error(SERVER_ERROR, e);

            RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_ERROR_PAGE);
            dispatcher.forward(request, response);
        }
    }
}

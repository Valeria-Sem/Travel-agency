package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.TourCustomerEntity;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.UserDetailsEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.service.*;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class GetCustomerTours implements Command {
    private final Logger LOGGER = Logger.getLogger(SaveUserDetails.class);

    private final String CURRENT_USER = "current_user";
    private final String USER_TOURS = "userTours";
    private final String SERVER_ERROR_MSG = "Server error in getting customer tours ";
    private final String ERROR_MSG = "errorMsg";
    private final String GO_TO_USER_PAGE_COMMAND = "controller?command=gotouserpage";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        List<TourEntity> userTours;
        UserEntity user;

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        TourCustomerService tourCustomerService = serviceProvider.getTourCustomerService();

        try {
            user = (UserEntity) session.getAttribute(CURRENT_USER);

            userTours = tourCustomerService.getAllCustomerTours(user.getId());

            session.setAttribute(USER_TOURS, userTours);

            response.sendRedirect(GO_TO_USER_PAGE_COMMAND);

        } catch (ServiceException e) {
            LOGGER.error(SERVER_ERROR_MSG, e);

            request.setAttribute(ERROR_MSG, SERVER_ERROR_MSG);
            request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
        }

    }
}

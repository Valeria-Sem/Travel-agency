package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.TourCustomerEntity;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.UserDetailsEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.service.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class GetCustomerTours implements Command {
    private final Logger LOGGER = Logger.getLogger(SaveUserDetails.class);

    private final String currentUser = "current_user";
    private final String currentUserDet = "current_userDet";
    private final String USER_TOURS = "userTours";
    private final String surname = "surname";
    private final String dateOfBirth = "date_of_birth";
    private final String citizenship = "citizenship";
    private final String passport = "passport";
    private final String dateOfIssue = "date_of_issue";
    private final String expirationDate = "expiration_date";
    private final String errorMessage = "Update error";
    private final String errorMessageS = "errorMsg";
    private final String findUser = "User with the same email was registered yet";
    private final String pathToUserPage = "controller?command=gotouserpage";
    private final String updateUserDet = "controller?command=updateuserdetinfo";


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
            user = (UserEntity) session.getAttribute(currentUser);

            userTours = tourCustomerService.getAllCustomerTours(user.getId());

            session.setAttribute(USER_TOURS, userTours);

            response.sendRedirect(pathToUserPage);

        } catch (ServiceException e) {
            request.setAttribute(errorMessageS, errorMessage);
            LOGGER.error("error in GetCustomerTours");
        }

    }
}

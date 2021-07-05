package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.UserDetailsEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.ServiceProvider;
import com.epam.travelAgency.service.UserDetailsService;
import com.epam.travelAgency.service.UserService;
import com.epam.travelAgency.service.validation.ValidationService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

public class UpdateUserDetInfo implements Command {
    private final Logger LOGGER = Logger.getLogger(UpdateUserInfo.class);

    private final String currentUser = "current_user";
    private final String currentUserDet = "current_userDet";
    private final String name = "name";
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

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String userName;
        String userSurname;
        LocalDate userDateOfB;
        String userCitizenship;
        String userPassport;
        LocalDate userDateOfI;
        LocalDate userEDate;

        userName = request.getParameter(name).trim();
        userSurname = request.getParameter(surname).trim();
        userDateOfB = LocalDate.parse(request.getParameter(dateOfBirth).trim());
        userCitizenship = request.getParameter(citizenship).trim();
        userPassport = request.getParameter(passport).trim();
        userDateOfI = LocalDate.parse(request.getParameter(dateOfIssue).trim());
        userEDate = LocalDate.parse(request.getParameter(expirationDate).trim());

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        UserDetailsService userDetailsService = serviceProvider.getUserDetailsService();

        try {
            UserDetailsEntity userDet = (UserDetailsEntity) session.getAttribute(currentUserDet);
            UserDetailsEntity newUserDet = new UserDetailsEntity(userDet.getId(), userDet.getIdUser(),
                    userName, userSurname, userDateOfB, userCitizenship, userPassport, userDateOfI, userEDate);

            if(userDetailsService.isUserDetailsUpdate(newUserDet)){
                session.setAttribute(currentUserDet, newUserDet);
            }


            request.setAttribute(errorMessageS, errorMessage);

            response.sendRedirect(pathToUserPage);

        } catch (ServiceException e) {
            LOGGER.error(errorMessage);
        }

    }
}

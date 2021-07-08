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

import javax.servlet.RequestDispatcher;
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
    private final String pathToUserPage = "controller?command=gotouserpage";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";
    private final String PATH_TO_USER_PAGE = "WEB-INF/jsp/user/userPage.jsp";
    private final String SERVER_ERROR= "Sorry server error.";
    private final String VALIDATION_ERROR= "Sorry server error.";

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


        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        UserDetailsService userDetailsService = serviceProvider.getUserDetailsService();
        ValidationService validationService = serviceProvider.getValidationService();

        try {
            userName = request.getParameter(name);
            userSurname = request.getParameter(surname);
            userDateOfB = LocalDate.parse(request.getParameter(dateOfBirth));
            userCitizenship = request.getParameter(citizenship);
            userPassport = request.getParameter(passport);
            userDateOfI = LocalDate.parse(request.getParameter(dateOfIssue));
            userEDate = LocalDate.parse(request.getParameter(expirationDate));

            if(!validationService.isPassportDataValid(userName, userSurname, userDateOfB.toString(), userCitizenship,
                    userPassport, userDateOfI.toString(), userEDate.toString())) {

                UserDetailsEntity userDet = (UserDetailsEntity) session.getAttribute(currentUserDet);
                UserDetailsEntity newUserDet = new UserDetailsEntity(userDet.getId(), userDet.getIdUser(),
                        userName, userSurname, userDateOfB, userCitizenship, userPassport, userDateOfI, userEDate);

                if (userDetailsService.isUserDetailsUpdate(newUserDet)) {
                    session.setAttribute(currentUserDet, newUserDet);

                } else {
                    request.setAttribute(errorMessageS, errorMessage);
                    request.getRequestDispatcher(PATH_TO_USER_PAGE).forward(request, response);
                }
            } else {
                request.setAttribute(errorMessageS, VALIDATION_ERROR);
                request.getRequestDispatcher(PATH_TO_USER_PAGE).forward(request, response);
            }

            response.sendRedirect(pathToUserPage);

        } catch (ServiceException | NullPointerException e) {
            LOGGER.error(errorMessage);

            request.setAttribute(errorMessageS, SERVER_ERROR);
            request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
        }

    }
}

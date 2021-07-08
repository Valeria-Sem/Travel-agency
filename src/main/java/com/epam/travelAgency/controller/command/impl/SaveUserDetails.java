package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.UserDetailsEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.ServiceProvider;
import com.epam.travelAgency.service.UserDetailsService;
import com.epam.travelAgency.service.validation.ValidationService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

public class SaveUserDetails implements Command {
    private final Logger LOGGER = Logger.getLogger(SaveUserDetails.class);

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
    private final String findUser = "User with the same email was registered yet";
    private final String pathToUserPage = "WEB-INF/jsp/user/userPage.jsp";
    private final String updateUserDet = "controller?command=updateuserdetinfo";
    private final String commandToUserPage = "controller?command=gotouserpage";

    private final String ERROR_MSG = "errorMsg";
    private final String SERVER_ERROR_MSG = "Server error. Please come back later";
    private final String VALIDATION_ERROR_MSG = "Validation error. Please check your data";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";



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

            UserDetailsEntity userDet = (UserDetailsEntity) session.getAttribute(currentUserDet);

                userName = request.getParameter(name).trim();
                userSurname = request.getParameter(surname).trim();
                userDateOfB = LocalDate.parse(request.getParameter(dateOfBirth).trim());
                userCitizenship = request.getParameter(citizenship).trim();
                userPassport = request.getParameter(passport).trim();
                userDateOfI = LocalDate.parse(request.getParameter(dateOfIssue).trim());
                userEDate = LocalDate.parse(request.getParameter(expirationDate).trim());

                if(!validationService.isPassportDataValid(userName, userSurname, userDateOfB.toString(), userCitizenship,
                        userPassport, userDateOfI.toString(), userEDate.toString())){
                    UserEntity user = (UserEntity) session.getAttribute(currentUser);
                    UserDetailsEntity newUserDet = new UserDetailsEntity(user.getId(),
                            userName, userSurname, userDateOfB, userCitizenship, userPassport, userDateOfI, userEDate);

                    if(userDetailsService.addUserDetails(newUserDet)){
                        newUserDet = userDetailsService.getUserDetailsByIdUser(user.getId());

                        session.setAttribute(currentUserDet, newUserDet);
                    }
                } else {
                    request.setAttribute(ERROR_MSG, VALIDATION_ERROR_MSG);
                    request.getRequestDispatcher(pathToUserPage).forward(request, response);
                }

                response.sendRedirect(commandToUserPage);

        } catch (ServiceException e) {
            LOGGER.error(SERVER_ERROR_MSG, e);

            request.setAttribute(ERROR_MSG, SERVER_ERROR_MSG);
            request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
        }

    }
}

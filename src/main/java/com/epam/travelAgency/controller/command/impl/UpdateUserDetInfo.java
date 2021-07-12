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

    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";
    private final String PATH_TO_USER_PAGE = "WEB-INF/jsp/user/userPage.jsp";

    private final String CURRENT_USER_DET = "current_userDet";
    private final String NAME = "name";
    private final String SURNAME = "surname";
    private final String DATE_OF_BTH = "date_of_birth";
    private final String CITIZENSHIP = "citizenship";
    private final String PASSPORT = "passport";
    private final String DATE_OF_ISS = "date_of_issue";
    private final String EXP_DATE = "expiration_date";
    private final String UPDATE_ERROR = "Update error";
    private final String GO_TO_USER_PAGE_COMMAND = "controller?command=gotouserpage";

    private final String ERROR_MSG = "errorMsg";
    private final String SERVER_ERROR_MSG = "Server error. Please come back later";
    private final String VALIDATION_ERROR= "Validation error. Check your passport data!";

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
            userName = request.getParameter(NAME);
            userSurname = request.getParameter(SURNAME);
            userDateOfB = LocalDate.parse(request.getParameter(DATE_OF_BTH));
            userCitizenship = request.getParameter(CITIZENSHIP);
            userPassport = request.getParameter(PASSPORT);
            userDateOfI = LocalDate.parse(request.getParameter(DATE_OF_ISS));
            userEDate = LocalDate.parse(request.getParameter(EXP_DATE));

            if(validationService.isPassportDataValid(userName, userSurname, userDateOfB.toString(), userCitizenship,
                    userPassport, userDateOfI.toString(), userEDate.toString())) {

                UserDetailsEntity userDet = (UserDetailsEntity) session.getAttribute(CURRENT_USER_DET);
                UserDetailsEntity newUserDet = new UserDetailsEntity(userDet.getId(), userDet.getIdUser(),
                        userName, userSurname, userDateOfB, userCitizenship, userPassport, userDateOfI, userEDate);

                if (userDetailsService.isUserDetailsUpdate(newUserDet)) {
                    session.setAttribute(CURRENT_USER_DET, newUserDet);
                    response.sendRedirect(GO_TO_USER_PAGE_COMMAND);

                } else {
                    request.setAttribute(ERROR_MSG, UPDATE_ERROR);
                    request.getRequestDispatcher(PATH_TO_USER_PAGE).forward(request, response);
                }
            } else {
                request.setAttribute(ERROR_MSG, VALIDATION_ERROR);

                request.getRequestDispatcher(PATH_TO_USER_PAGE).forward(request, response);
            }

        } catch (ServiceException | NullPointerException e) {
            LOGGER.error(SERVER_ERROR_MSG, e);

            request.setAttribute(ERROR_MSG, SERVER_ERROR_MSG);
            request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
        }

    }
}

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

    private final String CURRENT_USER = "current_user";
    private final String CURRENT_USER_DET = "current_userDet";
    private final String NAME = "name";
    private final String SURNAME = "surname";
    private final String DATE_OF_BTH = "date_of_birth";
    private final String CITIZENSHIP = "citizenship";
    private final String PASSPORT = "passport";
    private final String DATE_OF_ISS = "date_of_issue";
    private final String EXP_DATE = "expiration_date";
    private final String UPDATE_ERROR = "Update error";
    private final String FIND_USER_ERROR = "User with the same email was registered yet";
    private final String USER_PAGE_PATH = "WEB-INF/jsp/user/userPage.jsp";
    private final String GO_TO_USER_PAGE_COMMAND = "controller?command=gotouserpage";

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
            //            UserDetailsEntity userDet = (UserDetailsEntity) session.getAttribute(CURRENT_USER_DET);
            userName = request.getParameter(NAME).trim();
            userSurname = request.getParameter(SURNAME).trim();
            userDateOfB = LocalDate.parse(request.getParameter(DATE_OF_BTH).trim());
            userCitizenship = request.getParameter(CITIZENSHIP).trim();
            userPassport = request.getParameter(PASSPORT).trim();
            userDateOfI = LocalDate.parse(request.getParameter(DATE_OF_ISS).trim());
            userEDate = LocalDate.parse(request.getParameter(EXP_DATE).trim());

            if(validationService.isPassportDataValid(userName, userSurname, userDateOfB.toString(), userCitizenship,
                    userPassport, userDateOfI.toString(), userEDate.toString())){
                UserEntity user = (UserEntity) session.getAttribute(CURRENT_USER);
                UserDetailsEntity newUserDet = new UserDetailsEntity(user.getId(),
                        userName, userSurname, userDateOfB, userCitizenship, userPassport, userDateOfI, userEDate);

                if(userDetailsService.addUserDetails(newUserDet)){
                    newUserDet = userDetailsService.getUserDetailsByIdUser(user.getId());

                    session.setAttribute(CURRENT_USER_DET, newUserDet);

                    response.sendRedirect(GO_TO_USER_PAGE_COMMAND);
                }
            } else {
                request.setAttribute(ERROR_MSG, VALIDATION_ERROR_MSG);
                request.getRequestDispatcher(USER_PAGE_PATH).forward(request, response);
            }

        } catch (ServiceException e) {
            LOGGER.error(SERVER_ERROR_MSG, e);

            request.setAttribute(ERROR_MSG, SERVER_ERROR_MSG);
            request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
        }

    }
}

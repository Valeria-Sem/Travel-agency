package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.*;
import com.epam.travelAgency.service.*;
import com.epam.travelAgency.service.validation.ValidationService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UpdateUserInfo implements Command {
    private final Logger LOGGER = Logger.getLogger(UpdateUserInfo.class);

    private final String currentUser = "current_user";
    private final String email = "email";
    private final String password = "password";
    private final String errorMessage = "Update error";
    private final String errorMessageS = "errorMsg";
    private final String findUser = "User with the same email was registered yet";
    private final String pathToUserPage = "controller?command=gotouserpage";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";
    private final String PATH_TO_User_PAGE = "WEB-INF/jsp/user/userPage.jsp";

    private final String SERVER_ERROR= "Sorry server error.";
    private final String VALIDATION_ERROR= "Validation error.";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String userEmail;
        String userPassword;

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        UserService userService = serviceProvider.getUserService();
        ValidationService validationService = serviceProvider.getValidationService();

        try {
            userEmail = request.getParameter(email).trim();
            userPassword = request.getParameter(password);

//            if(userService.isUserByEmail(userEmail)){
//                request.setAttribute(errorMessage, findUser);
//                RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_ERROR_PAGE);
//                dispatcher.forward(request, response);
//
//            } else {
                UserEntity user = (UserEntity) session.getAttribute(currentUser);

                if (validationService.isAuthorisationDataValid(userEmail, userPassword)){
                    if (userService.isUserUpdate(user, userEmail, userPassword)) {
                        user.setEmail(userEmail);
                        user.setPassword(userPassword);

                    } else {
                        request.setAttribute(errorMessageS, errorMessage);

                        RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_User_PAGE);
                        dispatcher.forward(request, response);
                    }

                } else {
                    request.setAttribute(errorMessageS, VALIDATION_ERROR);
                    RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_User_PAGE);
                    dispatcher.forward(request, response);
                }

                session.setAttribute(currentUser, user);

                response.sendRedirect(pathToUserPage);
           // }

        } catch (ServiceException e) {
            LOGGER.error(SERVER_ERROR, e);

            request.setAttribute(errorMessageS, SERVER_ERROR);
            RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_ERROR_PAGE);
            dispatcher.forward(request, response);
        }

    }
}

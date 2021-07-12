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

    private final String CURRENT_USER = "current_user";
    private final String PASSWORD = "password";
    private final String UPDATE_ERROR = "Update error";
    private final String ERROR_ATTRIBUTE = "errorMsg";

    private final String USER_PAGE_COMMAND = "controller?command=gotouserpage";
    private final String ADMIN_PAGE_COMMAND = "controller?command=gotoadminpage";

    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";
    private final String PATH_TO_USER_PAGE = "WEB-INF/jsp/user/userPage.jsp";

    private final String SERVER_ERROR= "Sorry UPDATE server error.";
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
            UserEntity user = (UserEntity) session.getAttribute(CURRENT_USER);

            userEmail = user.getEmail();
            userPassword = request.getParameter(PASSWORD).trim();

            if (validationService.isAuthorisationDataValid(userEmail, userPassword)){
                if (userService.isUserUpdate(user, userEmail, userPassword)) {
                    user.setEmail(userEmail);
                    user.setPassword(userPassword);

                    session.setAttribute(CURRENT_USER, user);
                    if (user.getRole() == UserRole.AGENT) {
                        response.sendRedirect(ADMIN_PAGE_COMMAND);

                    } else{
                        response.sendRedirect(USER_PAGE_COMMAND);
                    }

                } else {
                    request.setAttribute(ERROR_ATTRIBUTE, UPDATE_ERROR);
                    request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
//
//                    RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_User_PAGE);
//                    dispatcher.forward(request, response);
                }

            } else {
                request.setAttribute(ERROR_ATTRIBUTE, VALIDATION_ERROR);
                request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
//                RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_User_PAGE);
//                dispatcher.forward(request, response);
            }

        } catch (ServiceException | NullPointerException e) {
            LOGGER.error(SERVER_ERROR, e);

            request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR);
            RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_ERROR_PAGE);
            dispatcher.forward(request, response);
        }

    }
}

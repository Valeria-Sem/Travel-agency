package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.*;
import com.epam.travelAgency.service.*;
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


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String userEmail;
        String userPassword;

        userEmail = request.getParameter(email).trim();
        userPassword = request.getParameter(password);

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        UserService userService = serviceProvider.getUserService();

        try {
            if(userService.isUserByEmail(userEmail)){
                request.setAttribute(errorMessage, findUser);
                response.sendRedirect(pathToUserPage);
                return;
            }

            UserEntity user = (UserEntity) session.getAttribute(currentUser);

            if(userService.isUserUpdate(user, userEmail, userPassword)){
                user.setEmail(userEmail);
                user.setPassword(userPassword);
            }

            session.setAttribute(currentUser, user);
            request.setAttribute(errorMessageS, errorMessage);

            response.sendRedirect(pathToUserPage);

        } catch (ServiceException e) {
            LOGGER.error(errorMessage);
        }

    }
}

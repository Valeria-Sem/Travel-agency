package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.UserDetailsEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.UserRole;
import com.epam.travelAgency.entity.WalletEntity;
import com.epam.travelAgency.service.*;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class Registration implements Command {
    private final Logger LOGGER = Logger.getLogger(Registration.class);

    private final String pathToUserPage = "controller?command=gotouserpage";
    private final String pathToRegistrationPage = "controller?command=gotoregistrationpage";
    private final String email = "email";
    private final String password = "password";
    private final String auth = "auth";
    private final String currentUser = "current_user";
    private final String errorMessage = "Registration error";
    private final String findUser = "User with the same email was registered yet";



    public Registration() {

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);

        String userEmail;
        String userPassword;
        UserRole userRole = UserRole.CUSTOMER;


        userEmail = request.getParameter(email).trim();
        userPassword = request.getParameter(password);


        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        UserService userService = serviceProvider.getUserService();

        try {
            if(userService.isUserByEmail(userEmail)){
                request.setAttribute(errorMessage, findUser);
                System.out.println("пользователь с почтой - " + userEmail + " уже существует");
                response.sendRedirect(pathToRegistrationPage);
                return;
            }

            UserEntity user = new UserEntity(userEmail, userPassword, userRole);
            userService.addUser(user);

            session.setAttribute(auth, true);
            session.setAttribute(currentUser, true);
            request.setAttribute(errorMessage, "");


            response.sendRedirect(pathToUserPage);

        } catch (ServiceException e) {
            LOGGER.error(errorMessage);
        }

    }
}

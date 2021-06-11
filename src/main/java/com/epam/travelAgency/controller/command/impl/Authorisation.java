package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.UserDetailsEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.WalletEntity;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.ServiceProvider;
import com.epam.travelAgency.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class Authorisation implements Command {
    private final Logger LOGGER = Logger.getLogger(Authorisation.class);

    private final String userEmail = "email";
    private final String userPassword = "password";
    private final String auth = "auth";
    private final String currentUser = "current_user";
    private final String errorMessage = "Error Auth";
    private final String pathToWrongModal = "controller?command=showwrongmodal";
    private final String pathToMainPage = "controller?command=gotomainpage";

    public Authorisation(){

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession();

        String email;
        String password;

        email = request.getParameter(userEmail).trim();
        password = request.getParameter(userPassword).trim();

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        Optional<UserEntity> user;

        try{
            user = userService.getUserByEmailAndPassword(email, password);

            if(user.isPresent()){
                session.setAttribute(auth, true);
                session.setAttribute(currentUser, true);

                response.sendRedirect(pathToMainPage);

            } else{
                response.sendRedirect(pathToWrongModal);
            }
        } catch (ServiceException e){
            LOGGER.error(errorMessage);
        }


    }
}

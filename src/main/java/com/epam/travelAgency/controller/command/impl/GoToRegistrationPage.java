package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.service.validation.impl.ValidationImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToRegistrationPage implements Command {
    private final String pathToRegistrationPage = "WEB-INF/jsp/registration/registrationPage.jsp";
    private final String locale = "locale";
    private final String lang = "lang";

    public GoToRegistrationPage(){

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter(locale) != null){
            ValidationImpl.userLocale = request.getParameter(locale);
        }
        request.getSession(true).setAttribute(lang, ValidationImpl.userLocale);

        RequestDispatcher dispatcher = request.getRequestDispatcher(pathToRegistrationPage);
        dispatcher.forward(request, response);
    }
}

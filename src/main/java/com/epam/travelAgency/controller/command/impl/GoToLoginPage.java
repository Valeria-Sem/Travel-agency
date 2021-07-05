package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.UserRole;
import com.epam.travelAgency.service.validation.impl.ValidationImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class GoToLoginPage implements Command {
    private final String currUser = "current_user";
    private final String pathToLoginPage = "/WEB-INF/jsp/authorisation/loginPage.jsp";
    private final String pathToAdminPage = "controller?command=gotoadminpage";
    private final String pathToUserPage = "controller?command=gotouserpage";
    private final String locale = "locale";
    private final String lang = "lang";
    private final String page = "page";
    private final String ROLE_ATTRIBUTE = "role";

    private final String pageCommand = "gotologinpage";


    public GoToLoginPage() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession();
        UserEntity currentUser = (UserEntity) session.getAttribute(currUser);
        UserRole role = (UserRole) session.getAttribute(ROLE_ATTRIBUTE);
        session.setAttribute(page, pageCommand);


//        if(request.getParameter(locale) != null){
//            ValidationImpl.userLocale = request.getParameter(locale);
//        }
//        request.getSession(true).setAttribute(lang, ValidationImpl.userLocale);

        if(currentUser != null){
            switch (role){
                case AGENT:
                    response.sendRedirect(pathToAdminPage);
                    break;

                case CUSTOMER:
                    response.sendRedirect(pathToUserPage);
                    break;
            }

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(pathToLoginPage);
            dispatcher.forward(request, response);
        }
    }
}

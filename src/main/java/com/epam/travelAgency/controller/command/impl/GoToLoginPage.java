package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToLoginPage implements Command {
    private final String currUser = "current_user";
    private final String pathToLoginPage = "/WEB-INF/jsp/loginPage.jsp";
    private final String pathToUserPage = "controller?command=gotouserpage";

    public GoToLoginPage() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession();
        Boolean currentUser = (Boolean) session.getAttribute(currUser);

        if(currentUser == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher(pathToLoginPage);
            dispatcher.forward(request, response);
    } else {
        response.sendRedirect(pathToUserPage);

    }
    }
}

package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout implements Command {
    private final String pathToMainPage = "/WEB-INF/jsp/main/mainPage.jsp";
    private final String auth = "auth";
    private final String currentUser = "current_user";
    private final String currentWallet = "current_wallet";
    private final String currentUserDet = "current_userDet";

    private final String role = "role";


    public Logout() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session != null){

            session.removeAttribute(auth);
            session.removeAttribute(currentUser);
            session.removeAttribute(currentWallet);
            session.removeAttribute(role);
            session.removeAttribute(auth);
            session.removeAttribute(currentUserDet);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(pathToMainPage);
        requestDispatcher.forward(request, response);
    }
}

package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToAdminPage implements Command {
    private final String pathToAdminPage = "WEB-INF/jsp/admin/adminPage.jsp";
    private final String locale = "locale";
    private final String lang = "lang";

    private final String page = "page";
    private final String pageCommand = "gotoadminpage";


    public GoToAdminPage() {

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute(page, pageCommand);


        RequestDispatcher dispatcher = request.getRequestDispatcher(pathToAdminPage);
        dispatcher.forward(request, response);
    }
}

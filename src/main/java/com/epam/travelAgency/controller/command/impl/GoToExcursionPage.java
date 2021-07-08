package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.service.validation.impl.ValidationImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToExcursionPage implements Command {
    private final String pathToExcursionPage = "WEB-INF/jsp/tours/excursion/excursion.jsp";
    private final String locale = "locale";
    private final String lang = "lang";

    private final String page = "page";
    private final String pageCommand = "gotoexcursionpage";

    private final String ERROR_MSG = "errorMsg";

    public GoToExcursionPage() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.setAttribute(page, pageCommand);

        RequestDispatcher dispatcher = request.getRequestDispatcher(pathToExcursionPage);
        dispatcher.forward(request, response);
    }
}

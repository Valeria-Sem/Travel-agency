package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.service.validation.impl.ValidationImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToShoppingPage implements Command {
    private final String pathToShoppingPage = "WEB-INF/jsp/tours/shopping/shopping.jsp";

    private final String page = "page";
    private final String pageCommand = "gotoshoppingpage";
    private final String ERROR_MSG = "errorMsg";

    public GoToShoppingPage() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.setAttribute(page, pageCommand);

        RequestDispatcher dispatcher = request.getRequestDispatcher(pathToShoppingPage);
        dispatcher.forward(request, response);
    }
}

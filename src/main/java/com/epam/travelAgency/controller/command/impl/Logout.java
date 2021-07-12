package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout implements Command {
    private final String MAIN_PAGE_PATH = "/WEB-INF/jsp/main/mainPage.jsp";

    private final String AUTH = "auth";
    private final String CURRENT_USER = "current_user";
    private final String CURRENT_WALLET = "current_wallet";
    private final String CURRENT_USER_DET = "current_userDet";
    private final String ROLE = "role";
    private final String PAGE = "page";
    private final String PAGE_COMMAND = "gotomainpage";


    public Logout() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session != null){

            session.removeAttribute(AUTH);
            session.removeAttribute(CURRENT_USER);
            session.removeAttribute(CURRENT_WALLET);
            session.removeAttribute(ROLE);
            session.removeAttribute(CURRENT_USER_DET);

            session.setAttribute(PAGE, PAGE_COMMAND);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(MAIN_PAGE_PATH);
        requestDispatcher.forward(request, response);
    }
}

package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToCreatorPage implements Command {
    private final Logger LOGGER = Logger.getLogger(GoToCreatorPage.class);

    private final String PATH_TO_CREATOR_PAGE = "WEB-INF/jsp/tours/creator/creator.jsp";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";

    private final String ERROR_MSG = "errorMsg";
    private final String SERVER_ERROR_MSG = "Server error. Please come back later";

    private final String PAGE = "page";
    private final String PAGE_COMMAND = "gotodatespage";

    public GoToCreatorPage(){

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            session.setAttribute(PAGE, PAGE_COMMAND);

            RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_CREATOR_PAGE);
            dispatcher.forward(request, response);

        } catch (Exception e){
            LOGGER.error(SERVER_ERROR_MSG, e);

            request.setAttribute(ERROR_MSG, SERVER_ERROR_MSG);
            request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
        }
    }
}

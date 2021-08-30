package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.UserRole;
import com.epam.travelAgency.service.validation.impl.ValidationImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class GoToLoginPage implements Command {
    private final Logger LOGGER = Logger.getLogger(GoToLoginPage.class);

    private final String CURRENT_USER = "current_user";
    private final String ROLE_ATTRIBUTE = "role";

    private final String PATH_TO_AUTHORISATION_PAGE = "/WEB-INF/jsp/authorisation/loginPage.jsp";
    private final String ERROR_PAGE_PATH = "WEB-INF/jsp/error/errorPage.jsp";

    private final String PATH_TO_ADMIN_PAGE = "controller?command=gotoadminpage";
    private final String PATH_TO_USER_PAGE = "controller?command=gotouserpage";
    private final String AUTH_COMMAND = "controller?command=authorisation";

    private final String PAGE = "page";
    private final String PAGE_COMMAND = "gotologinpage";

    private final String ERROR_ATTRIBUTE = "errorMsg";

    private final String SERVER_ERROR= "Sorry, login server error.";


    public GoToLoginPage() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession();

        try {
            UserEntity currentUser = (UserEntity) session.getAttribute(CURRENT_USER);
            UserRole role = (UserRole) session.getAttribute(ROLE_ATTRIBUTE);

            session.setAttribute(PAGE, PAGE_COMMAND);

            if (currentUser != null) {
                switch (role) {
                    case AGENT:
                        response.sendRedirect(PATH_TO_ADMIN_PAGE);
                        break;

                    case CUSTOMER:
                        response.sendRedirect(PATH_TO_USER_PAGE);
                        break;
                }
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_AUTHORISATION_PAGE);
                dispatcher.forward(request, response);
            }
        } catch (Exception e){
            request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR);
            request.getRequestDispatcher(ERROR_PAGE_PATH).forward(request, response);

            LOGGER.error(SERVER_ERROR, e);
        }
    }
}

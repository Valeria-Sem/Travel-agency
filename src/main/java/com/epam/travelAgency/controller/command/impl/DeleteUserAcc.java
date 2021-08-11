package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.SaleEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.WalletEntity;
import com.epam.travelAgency.service.*;
import com.epam.travelAgency.service.validation.ValidationService;
import com.sun.jmx.remote.protocol.rmi.ServerProvider;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteUserAcc implements Command {
    private final Logger LOGGER = Logger.getLogger(DeleteUserAcc.class);

    private final String LOGOUT = "controller?command=logout";

    private final String CURRENT_USER = "current_user";
    private final String ERROR_ATTRIBUTE = "errorMsg";

    private final String SERVER_ERROR= "Sorry, login server error.";
    private final String ERROR_PAGE_PATH = "WEB-INF/jsp/error/errorPage.jsp";

    public DeleteUserAcc(){

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession();

        if (session != null){
            try {
                UserEntity user = (UserEntity) session.getAttribute(CURRENT_USER);

                ServiceProvider serviceProvider = ServiceProvider.getInstance();
                UserService userService = serviceProvider.getUserService();

                userService.deleteUser(user.getId());

                response.sendRedirect(LOGOUT);
            } catch (ServiceException e) {
                request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR);
                request.getRequestDispatcher(ERROR_PAGE_PATH).forward(request, response);

                LOGGER.error(SERVER_ERROR, e);
            }

        }
    }
}


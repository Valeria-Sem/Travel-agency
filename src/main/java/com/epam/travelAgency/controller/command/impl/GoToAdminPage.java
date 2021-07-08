package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.TourStatus;
import com.epam.travelAgency.entity.UserDetailsEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.service.*;
import com.epam.travelAgency.service.validation.ValidationService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class GoToAdminPage implements Command {
    private final Logger LOGGER = Logger.getLogger(GoToUserPage.class);

    private final String PATH_TO_ADMIN_PAGE = "WEB-INF/jsp/admin/adminPage.jsp";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/admin/adminPage.jsp";

    private final String USERS_ATTRIBUTE = "users";
    private final String TOURS_ATTRIBUTE = "tours";
    private final String TOURS_STATUSES = "statuses";

    private final String ERROR_MSG_ATTRIBUTE = "errorMsg";
    private final String SERVER_ERROR_MSG = "Server error. Please come back later";
    private final String LOGGER_ERROR_MSG = "Server error in GoToAdminPage";

    private final String PAGE = "page";
    private final String PAGE_COMMAND = "gotoadminpage";


    public GoToAdminPage() {

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<TourEntity> tours;
        List<UserEntity> users;
        EnumSet<TourStatus> statuses;


        ServiceProvider provider = ServiceProvider.getInstance();

        TourService tourService = provider.getTourService();
        UserService userService = provider.getUserService();
        try{
            tours = tourService.getAllTours();
            users = userService.getAllCustomers();

            statuses = EnumSet.allOf(TourStatus.class);

            session.setAttribute(USERS_ATTRIBUTE, users);
            session.setAttribute(TOURS_ATTRIBUTE, tours);
            session.setAttribute(TOURS_STATUSES, statuses);

            session.setAttribute(PAGE, PAGE_COMMAND);

            RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_ADMIN_PAGE);
            dispatcher.forward(request, response);

        } catch (ServiceException e){
            LOGGER.error(LOGGER_ERROR_MSG, e);

            request.setAttribute(ERROR_MSG_ATTRIBUTE, SERVER_ERROR_MSG);
            request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
        }
    }
}

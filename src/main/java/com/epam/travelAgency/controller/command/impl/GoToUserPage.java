package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.*;
import com.epam.travelAgency.service.*;
import com.epam.travelAgency.service.validation.ValidationService;
import com.epam.travelAgency.service.validation.impl.ValidationImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToUserPage implements Command {
    private final Logger LOGGER = Logger.getLogger(GoToUserPage.class);

    private final String USER_PAGE_PATH = "WEB-INF/jsp/user/userPage.jsp";

    private final String PAGE = "page";
    private final String PAGE_COMMAND = "gotouserpage";

    private final String USER_TOURS = "userTours";
    private final String CURRENT_USER = "current_user";
    private final String CURRENT_USER_DET = "current_userDet";

    private final String ERROR_MSG = "errorMsg";
    private final String SERVER_ERROR_MSG = "Server error. Please come back later";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";


    public GoToUserPage(){

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<TourEntity> userTours;
        UserEntity user;

        ServiceProvider provider = ServiceProvider.getInstance();

        ValidationService validationService = provider.getValidationService();
        UserDetailsService userDetailsService = provider.getUserDetailsService();
        TourCustomerService tourCustomerService = provider.getTourCustomerService();

        try{
            user = (UserEntity) session.getAttribute(CURRENT_USER);

            UserDetailsEntity userDet = userDetailsService.getUserDetailsByIdUser(user.getId());
            userTours = tourCustomerService.getAllCustomerTours(user.getId());

            session.setAttribute(USER_TOURS, userTours);

            session.setAttribute(CURRENT_USER_DET, userDet);

            session.setAttribute(PAGE, PAGE_COMMAND);

            RequestDispatcher dispatcher = request.getRequestDispatcher(USER_PAGE_PATH);
            dispatcher.forward(request, response);

        } catch (ServiceException e){
            LOGGER.error(SERVER_ERROR_MSG, e);

            request.setAttribute(ERROR_MSG, SERVER_ERROR_MSG);
            request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
        }
    }
}

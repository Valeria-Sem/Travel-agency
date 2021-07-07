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

    private final String pathToAdminPage = "WEB-INF/jsp/admin/adminPage.jsp";
    private final String locale = "locale";
    private final String lang = "lang";
    private final String CURRENT_USER_ATTRIBUTE = "current_user";
    private final String CURRENT_WALLET_ATTRIBUTE = "current_wallet";
    private final String USERS_ATTRIBUTE = "users";
    private final String TOURS_ATTRIBUTE = "tours";
    private final String TOURS_STATUSES = "statuses";


    private final String page = "page";
    private final String pageCommand = "gotoadminpage";


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
//            if(session.getAttribute(USER_TOURS) == null) {
//                response.sendRedirect(GETCUSTOMERTOURS_COMMAND);
//            } else {

//            user = (UserEntity) session.getAttribute(CURRENT_USER_ATTRIBUTE);
//
//            UserDetailsEntity userDet = userDetailsService.getUserDetailsByIdUser(user.getId());
//            userTours = tourCustomerService.getAllCustomerTours(user.getId());
            tours = tourService.getAllTours();
            users = userService.getAllCustomers();

            statuses = EnumSet.allOf(TourStatus.class);

            session.setAttribute(USERS_ATTRIBUTE, users);
            session.setAttribute(TOURS_ATTRIBUTE, tours);
            session.setAttribute(TOURS_STATUSES, statuses);

            session.setAttribute(page, pageCommand);

            RequestDispatcher dispatcher = request.getRequestDispatcher(pathToAdminPage);
            dispatcher.forward(request, response);
            //        }

        } catch (ServiceException e){
            LOGGER.error("error in GoToUserPage");
        }
    }
}

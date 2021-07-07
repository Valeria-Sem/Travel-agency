package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.UserDetailsEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.WalletEntity;
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

    private static final String userPagePath = "WEB-INF/jsp/user/userPage.jsp";
    private final String locale = "locale";
    private final String lang = "lang";
    private final String page = "page";
    private final String pageCommand = "gotouserpage";
    private final String GETCUSTOMERTOURS_COMMAND = "getcustomertours";

    private final String currentUser = "current_user";
    private final String USER_TOURS = "userTours";

    //   private final String currentUser = "current_";

    private final String currentUserDet = "current_userDet";
    private final String currentWallet = "current_wallet";
    private final String role = "role";


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
//            if(session.getAttribute(USER_TOURS) == null) {
//                response.sendRedirect(GETCUSTOMERTOURS_COMMAND);
//            } else {

            user = (UserEntity) session.getAttribute(currentUser);

            UserDetailsEntity userDet = userDetailsService.getUserDetailsByIdUser(user.getId());
            userTours = tourCustomerService.getAllCustomerTours(user.getId());

            session.setAttribute(USER_TOURS, userTours);

            session.setAttribute(currentUserDet, userDet);

            session.setAttribute(page, pageCommand);

            RequestDispatcher dispatcher = request.getRequestDispatcher(userPagePath);
            dispatcher.forward(request, response);
    //        }

        } catch (ServiceException e){
            LOGGER.error("error in GoToUserPage");
        }
    }
}

package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.SaleEntity;
import com.epam.travelAgency.entity.TourEntity;
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
import java.util.List;

public class ShowUserInfo implements Command {
    private final Logger LOGGER = Logger.getLogger(ShowUserInfo.class);

    private static final String userPagePath = "WEB-INF/jsp/user/userInfo.jsp";
    private final String locale = "locale";
    private final String lang = "lang";
    private final String page = "page";
    private final String pageCommand = "gotouserpage";
    private final String GETCUSTOMERTOURS_COMMAND = "getcustomertours";
    private final String ID_USER = "id_user";
    private final String USER_DETAILS = "userDet";
    private final String USER_SALE = "userSale";

    private final String currentUser = "current_user";
    private final String USER_TOURS = "userTours";

    //   private final String currentUser = "current_";

    private final String currentUserDet = "current_userDet";
    private final String currentWallet = "current_wallet";
    private final String role = "role";


    public ShowUserInfo(){

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<TourEntity> userTours;
        int userId;
        UserDetailsEntity userDet;
        SaleEntity sale;

        ServiceProvider provider = ServiceProvider.getInstance();

        ValidationService validationService = provider.getValidationService();
        UserDetailsService userDetailsService = provider.getUserDetailsService();
        SaleService saleService = provider.getSaleService();

        try{
            if(request.getParameter(ID_USER) != null) {
                userId = Integer.parseInt(request.getParameter(ID_USER));
            } else {
                userId = (int) session.getAttribute(ID_USER);
            }
                userDet = userDetailsService.getUserDetailsByIdUser(userId);
                sale = saleService.getSaleByIdUser(userId);

                session.setAttribute(USER_DETAILS, userDet);

                session.setAttribute(USER_SALE, sale);
                session.setAttribute(ID_USER, userId);

                session.setAttribute(page, pageCommand);



            RequestDispatcher dispatcher = request.getRequestDispatcher(userPagePath);
            dispatcher.forward(request, response);

        } catch (ServiceException e){
            LOGGER.error("error in GoToUserPage");
            e.printStackTrace();
        }
    }
}

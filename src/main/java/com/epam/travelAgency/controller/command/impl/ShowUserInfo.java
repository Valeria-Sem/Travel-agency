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

    private final String USER_PAGE_PATH = "WEB-INF/jsp/user/userInfo.jsp";
    private final String PAGE = "page";
    private final String PAGE_COMMAND = "gotouserpage";
    private final String ID_USER = "id_user";
    private final String USER_DETAILS = "userDet";
    private final String USER_SALE = "userSale";

    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";

    private final String ERROR_ATTRIBUTE = "errorMsg";
    private final String SERVER_ERROR= "Sorry server error.";


    public ShowUserInfo(){

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int userId;
        UserDetailsEntity userDet;
        SaleEntity sale;

        ServiceProvider provider = ServiceProvider.getInstance();

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

            session.setAttribute(PAGE, PAGE_COMMAND);

            RequestDispatcher dispatcher = request.getRequestDispatcher(USER_PAGE_PATH);
            dispatcher.forward(request, response);

        } catch (ServiceException e){
            LOGGER.error(SERVER_ERROR, e);

            request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR);
            RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_ERROR_PAGE);
            dispatcher.forward(request, response);
        }
    }
}

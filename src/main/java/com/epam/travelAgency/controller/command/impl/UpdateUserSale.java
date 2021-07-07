package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.SaleEntity;
import com.epam.travelAgency.entity.UserDetailsEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.service.SaleService;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.ServiceProvider;
import com.epam.travelAgency.service.UserDetailsService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

public class UpdateUserSale implements Command {
    private final Logger LOGGER = Logger.getLogger(UpdateUserInfo.class);

    private final String USER_SALE = "userSale";
    private final String currentUser = "current_user";
    private final String SALE_ATTRIBUTE = "sale";
    private final String surname = "surname";
    private final String dateOfBirth = "date_of_birth";
    private final String citizenship = "citizenship";
    private final String passport = "passport";
    private final String dateOfIssue = "date_of_issue";
    private final String expirationDate = "expiration_date";
    private final String errorMessage = "Update error";
    private final String errorMessageS = "errorMsg";
    private final String findUser = "User with the same email was registered yet";
    private final String pathToUserPage = "controller?command=gotouserpage";
    private final String pathToUserInfo = "controller?command=showuserinfo";
    private final String ID_USER = "id_user";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        int newSale;
        int newTourCount;
        int userId;
        SaleEntity sale;

      //  newSale = Integer.parseInt(request.getParameter(SALE_ATTRIBUTE));
//        user = (UserEntity) session.getAttribute(currentUser);

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        SaleService saleService = serviceProvider.getSaleService();

        try {
            userId = (int) session.getAttribute(ID_USER);
            newSale = Integer.parseInt(request.getParameter(SALE_ATTRIBUTE));

            sale = saleService.updateSaleInfo(userId ,newSale);

            session.setAttribute(USER_SALE, sale);

            request.setAttribute(errorMessageS, errorMessage);

            response.sendRedirect(pathToUserInfo);

        } catch (ServiceException e) {
            LOGGER.error(errorMessage);
        }
    }
}

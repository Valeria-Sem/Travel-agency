package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.*;
import com.epam.travelAgency.service.*;
import com.epam.travelAgency.service.validation.ValidationService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class Registration implements Command {
    private final Logger LOGGER = Logger.getLogger(Registration.class);

    private final String GO_TO_USER_PAGE_COMMAND = "controller?command=gotouserpage";
    private final String ERROR_PAGE_PATH = "WEB-INF/jsp/error/errorPage.jsp";
    private final String REG_PAGE_PATH = "WEB-INF/jsp/registration/registrationPage.jsp";

    private final String GO_REG_PAGE_COMMAND = "controller?command=gotoregistrationpage";
    private final String EMAIL = "email";
    private final String PASSWORD = "password";
    private final String AUTH = "auth";
    private final String CURRENT_USER = "current_user";
    private final String CURRENT_SALE = "current_sale";
    private final String CURRENT_WALLET = "current_wallet";
    private final String ERROR_ATTRIBUTE = "errorMsg";
    private final String FIND_USER_ERROR = "Registration error. User with the same email was registered yet";
    private final String VALIDATION_ERROR = "Registration error. You have entered invalid data";
    private final String SERVER_ERROR= "Sorry. registration server error.";

    public Registration() {

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);

        String userEmail;
        String userPassword;
        WalletEntity wallet;
        SaleEntity sale;

        UserRole userRole = UserRole.CUSTOMER;


        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        ValidationService validationService = serviceProvider.getValidationService();
        UserService userService = serviceProvider.getUserService();
        WalletService walletService = serviceProvider.getWalletService();
        SaleService saleService = serviceProvider.getSaleService();

        try {
            userEmail = request.getParameter(EMAIL).trim();
            userPassword = request.getParameter(PASSWORD);

            if(validationService.isAuthorisationDataValid(userEmail, userPassword)){

                if(userService.isUserByEmail(userEmail)){
                        request.setAttribute(ERROR_ATTRIBUTE, FIND_USER_ERROR);
                        request.getRequestDispatcher(REG_PAGE_PATH).forward(request, response);

                } else {
                        UserEntity user = new UserEntity(userEmail, userPassword, userRole);
                        userService.addUser(user);

                        user = userService.getUserByEmailAndPassword(userEmail, userPassword);
                        wallet = walletService.saveNewWallet(user.getId());
                        sale = saleService.saveNewSaleInfo(user.getId());

                        session.setAttribute(AUTH, true);
                        session.setAttribute(CURRENT_USER, user);
                        session.setAttribute(CURRENT_WALLET, wallet);
                        session.setAttribute(CURRENT_SALE, sale);


                        response.sendRedirect(GO_TO_USER_PAGE_COMMAND);
                }
            } else {
                request.setAttribute(ERROR_ATTRIBUTE, VALIDATION_ERROR);
                request.getRequestDispatcher(REG_PAGE_PATH).forward(request, response);
            }

        } catch (ServiceException e) {
            request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR);
            request.getRequestDispatcher(ERROR_PAGE_PATH).forward(request, response);

            LOGGER.error(SERVER_ERROR, e);
        }

    }
}

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

    private final String pathToUserPage = "controller?command=gotouserpage";
    private final String pathToErrorPage = "WEB-INF/jsp/error/errorPage.jsp";
    private final String pathToRegistrationPage = "WEB-INF/jsp/registration/registrationPage.jsp";

    private final String ToRegistrationPageCommand = "controller?command=gotoregistrationpage";
    private final String email = "email";
    private final String password = "password";
    private final String auth = "auth";
    private final String currentUser = "current_user";
    private final String CURRENT_SALE = "current_sale";
    private final String currentWallet = "current_wallet";
    private final String errorMessage = "errorMsg";
    private final String findUser = "Registration error. User with the same email was registered yet";
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
            userEmail = request.getParameter(email).trim();
            userPassword = request.getParameter(password);

            if(validationService.isAuthorisationDataValid(userEmail, userPassword)){

                if(userService.isUserByEmail(userEmail)){
                        request.setAttribute(errorMessage, findUser);
                        request.getRequestDispatcher(pathToRegistrationPage).forward(request, response);;

                } else {
                        UserEntity user = new UserEntity(userEmail, userPassword, userRole);
                        userService.addUser(user);

                        user = userService.getUserByEmailAndPassword(userEmail, userPassword);
                        wallet = walletService.saveNewWallet(user.getId());
                        sale = saleService.saveNewSaleInfo(user.getId());

                        session.setAttribute(auth, true);
                        session.setAttribute(currentUser, user);
                        session.setAttribute(currentWallet, wallet);
                        session.setAttribute(CURRENT_SALE, sale);


                        response.sendRedirect(pathToUserPage);
                }
            } else {
                request.setAttribute(errorMessage, VALIDATION_ERROR);
                request.getRequestDispatcher(pathToRegistrationPage).forward(request, response);
            }

        } catch (ServiceException e) {
            request.setAttribute(errorMessage, SERVER_ERROR);
            request.getRequestDispatcher(pathToErrorPage).forward(request, response);

            LOGGER.error(SERVER_ERROR, e);
        }

    }
}

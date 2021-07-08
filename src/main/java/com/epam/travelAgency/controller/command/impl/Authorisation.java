package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.SaleEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.WalletEntity;
import com.epam.travelAgency.service.*;
import com.epam.travelAgency.service.validation.ValidationService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Authorisation implements Command {
    private final Logger LOGGER = Logger.getLogger(Authorisation.class);

    private final String EMAIL_ATTRIBUTE = "email";
    private final String PASSWORD_ATTRIBUTE = "password";
    private final String AUTH_ATTRIBUTE = "auth";
    private final String CURRENT_USER_ATTRIBUTE = "current_user";
    private final String CURRENT_WALLET_ATTRIBUTE = "current_wallet";
    private final String CURRENT_SALE_ATTRIBUTE = "current_sale";
    private final String ROLE_ATTRIBUTE = "role";
    private final String SERVER_ERROR_MESSAGE = "Error Auth";
    private final String VALIDATION_ERROR_MESSAGE = "Error Auth";
    private final String ERROR_ATTRIBUTE = "Error Auth";
    private final String SHOW_WRONG_MODAL_COMMAND = "controller?command=showwrongmodal";
    private final String GO_TO_MAIN_PAGE_COMMAND = "controller?command=gotomainpage";
    private final String GO_TO_LOGIN_PAGE_COMMAND = "controller?command=gotologinpage";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";

    public Authorisation(){

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession();

        String email;
        String password;

        UserEntity user;
        WalletEntity wallet;
        SaleEntity sale;

        ServiceProvider provider = ServiceProvider.getInstance();

        ValidationService validationService = provider.getValidationService();
        UserService userService = provider.getUserService();
        WalletService walletService = provider.getWalletService();
        SaleService saleService = provider.getSaleService();

        try{
            email = request.getParameter(EMAIL_ATTRIBUTE).trim();
            password = request.getParameter(PASSWORD_ATTRIBUTE).trim();

            if(validationService.isAuthorisationDataValid(email, password)){
                user = userService.getUserByEmailAndPassword(email, password);

                if(user != null){
                    wallet = walletService.getWalletByUserId(user.getId());
                    sale = saleService.getSaleByIdUser(user.getId());

                    session.setAttribute(AUTH_ATTRIBUTE, true);
                    session.setAttribute(CURRENT_USER_ATTRIBUTE, user);
                    session.setAttribute(CURRENT_WALLET_ATTRIBUTE, wallet);
                    session.setAttribute(CURRENT_SALE_ATTRIBUTE, sale);
                    session.setAttribute(ROLE_ATTRIBUTE, user.getRole());

                    response.sendRedirect(GO_TO_MAIN_PAGE_COMMAND);

                } else{
                    response.sendRedirect(SHOW_WRONG_MODAL_COMMAND);
                }
            } else {
                request.setAttribute(ERROR_ATTRIBUTE, VALIDATION_ERROR_MESSAGE);
                response.sendRedirect(GO_TO_LOGIN_PAGE_COMMAND);
            }
        } catch (ServiceException e){
            LOGGER.error(SERVER_ERROR_MESSAGE, e);

            request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR_MESSAGE);
            request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
        }
    }
}

package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.SaleEntity;
import com.epam.travelAgency.entity.UserDetailsEntity;
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
import java.util.Optional;

public class Authorisation implements Command {
    private final Logger LOGGER = Logger.getLogger(Authorisation.class);

    private final String userEmail = "email";
    private final String userPassword = "password";
    private final String auth = "auth";
    private final String currentUser = "current_user";
    private final String currentWallet = "current_wallet";
    private final String current_SALE = "current_sale";
    private final String role = "role";
    private final String errorMessage = "Error Auth";
    private final String pathToWrongModal = "controller?command=showwrongmodal";
    private final String pathToMainPage = "controller?command=gotomainpage";

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

        email = request.getParameter(userEmail).trim();
        password = request.getParameter(userPassword).trim();

        ServiceProvider provider = ServiceProvider.getInstance();

        ValidationService validationService = provider.getValidationService();
        UserService userService = provider.getUserService();
        WalletService walletService = provider.getWalletService();
        SaleService saleService = provider.getSaleService();


        try{
            if(validationService.isEmailValid(email) && validationService.isPasswordValid(password)){
                user = userService.getUserByEmailAndPassword(email, password);

                if(user != null){
                    wallet = walletService.getWalletByUserId(user.getId());
                    sale = saleService.getSaleByIdUser(user.getId());

                    session.setAttribute(auth, true);
                    session.setAttribute(currentUser, user);
                    session.setAttribute(currentWallet, wallet);
                    session.setAttribute(current_SALE, sale);
                    session.setAttribute(role, user.getRole());

                    response.sendRedirect(pathToMainPage);

                } else{
                    response.sendRedirect(pathToWrongModal);
                }
            } else {
                System.out.println("Проверь свои регулярки на jsp :)");
                response.sendRedirect(pathToWrongModal);
            }
        } catch (ServiceException e){
            LOGGER.error(errorMessage);
        }


    }
}

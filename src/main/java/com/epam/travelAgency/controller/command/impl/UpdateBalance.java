package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.SaleEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.WalletEntity;
import com.epam.travelAgency.service.SaleService;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.ServiceProvider;
import com.epam.travelAgency.service.WalletService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateBalance implements Command {
    private final Logger LOGGER = Logger.getLogger(UpdateBalance.class);

    private final String NEW_BALANCE = "newBalance";
    private final String current_WALLET = "current_wallet";
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

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        double newBalance;
        WalletEntity wallet;

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        WalletService walletService = serviceProvider.getWalletService();

        try {
            wallet = (WalletEntity) session.getAttribute(current_WALLET);
            newBalance = Double.parseDouble(request.getParameter(NEW_BALANCE));
            newBalance += wallet.getBalance();

            if(walletService.updateBalance(wallet.getId(), newBalance)){
                wallet.setBalance(newBalance);
                request.setAttribute(current_WALLET, wallet);
            }


            response.sendRedirect(pathToUserPage);

        } catch (ServiceException e) {
            request.setAttribute(errorMessageS, errorMessage);
            LOGGER.error(errorMessage);
            e.printStackTrace();
        }
    }
}

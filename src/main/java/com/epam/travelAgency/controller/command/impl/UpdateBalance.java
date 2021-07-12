package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.SaleEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.WalletEntity;
import com.epam.travelAgency.service.SaleService;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.ServiceProvider;
import com.epam.travelAgency.service.WalletService;
import com.epam.travelAgency.service.validation.ValidationService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateBalance implements Command {
    private final Logger LOGGER = Logger.getLogger(UpdateBalance.class);

    private final String NEW_BALANCE = "newBalance";
    private final String CURRENT_WALLET = "current_wallet";
    private final String ERROR_ATTRIBUTE = "errorMsg";
    private final String UPDATE_ERROR = "Update error";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";
    private final String SERVER_ERROR= "Sorry update server error.";
    private final String PAGE = "page";
    private final String PATH = "controller?command=";

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
        ValidationService validationService = serviceProvider.getValidationService();

        try {
            wallet = (WalletEntity) session.getAttribute(CURRENT_WALLET);
            newBalance = Double.parseDouble(request.getParameter(NEW_BALANCE));
            newBalance += wallet.getBalance();

            if(walletService.updateBalance(wallet.getId(), newBalance)){
                wallet.setBalance(newBalance);
                request.setAttribute(CURRENT_WALLET, wallet);
            } else {
                request.setAttribute(ERROR_ATTRIBUTE, UPDATE_ERROR);
                request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
            }

            String command = (String) request.getSession().getAttribute(PAGE);
            response.sendRedirect(PATH + command);

        } catch (ServiceException e) {
            request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR);
            LOGGER.error(SERVER_ERROR, e);

            RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_ERROR_PAGE);
            dispatcher.forward(request, response);
        }
    }
}

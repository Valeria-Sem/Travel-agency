package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.*;
import com.epam.travelAgency.service.*;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class BuyTour implements Command {
    private final Logger LOGGER = Logger.getLogger(GoToTourDetails.class);

    private final String pathToDetailsPage = "WEB-INF/jsp/tours/details/detailsPage.jsp";
    private final String pathToErrorPage = "WEB-INF/jsp/error/errorPage.jsp";

    private final String TOUR_ATTRIBUTE = "tour";
    private final String CURRENT_USER_ATTRIBUTE = "current_user";
    private final String CURRENT_WALLET_ATTRIBUTE = "current_wallet";
    private final String CURRENT_SALE_ATTRIBUTE = "current_sale";
    private final String DATES_PARAM = "dates";
    private final String auth = "auth";
    private final String SEND_EMAIL_COMMAND = "controller?command=sendemail";
    private final String GO_TO_LOGIN_PAGE_COMMAND = "controller?command=gotologinpage";
    private final String ERROR_MSG_ATTRIBUTE = "errorMsg";
    private final String DISCOUNT_PRICE = "discountPrice";


    private final String lang = "lang";

    private final String page = "page";
    private final String path = "controller?command=";

    public BuyTour() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        UserEntity user;
        TourEntity tour;
        WalletEntity wallet;
        SaleEntity sale;
        String dates;
        double discountPrice = 0;
        double discount;
        double price = 0;
        double newBalance;
        int newTourCount = 1;

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        TourCustomerService tourCustomerService = serviceProvider.getTourCustomerService();
        WalletService walletService = serviceProvider.getWalletService();
        SaleService saleService = serviceProvider.getSaleService();

        try{
            if(session.getAttribute(auth) != null && (Boolean) session.getAttribute(auth)) {
                tour = (TourEntity) session.getAttribute(TOUR_ATTRIBUTE);
                user = (UserEntity) session.getAttribute(CURRENT_USER_ATTRIBUTE);
                sale = (SaleEntity) session.getAttribute(CURRENT_SALE_ATTRIBUTE);
                wallet = (WalletEntity) session.getAttribute(CURRENT_WALLET_ATTRIBUTE);

                if (tourCustomerService.buyTour(tour.getId(), user.getId())) {

                    double newSale = sale.getSale() * 0.01;
                    discount = tour.getPrice() * newSale;
                    discountPrice = tour.getPrice() - discount;
                    newBalance = wallet.getBalance() - discountPrice;

                    if(walletService.updateBalance(wallet.getId(), newBalance)){
                        wallet.setBalance(newBalance);
                        request.setAttribute(CURRENT_WALLET_ATTRIBUTE, wallet);

                        newTourCount += sale.getToursCount();
                        sale = saleService.updateToursCount(user.getId(), newTourCount);

                        session.setAttribute(CURRENT_SALE_ATTRIBUTE, sale);
                        session.setAttribute(DATES_PARAM, request.getParameter(DATES_PARAM));
                        request.setAttribute(DISCOUNT_PRICE, discountPrice);
                        response.sendRedirect(SEND_EMAIL_COMMAND);

                    } else {
                        request.setAttribute(ERROR_MSG_ATTRIBUTE, "Оплата не прошла. Не хватает денег на счёте");
                        RequestDispatcher dispatcher = request.getRequestDispatcher(pathToErrorPage);
                        dispatcher.forward(request, response);
                    }

                } else {
                    request.setAttribute(ERROR_MSG_ATTRIBUTE, "Серверная ошибка покупки тура. " +
                            "Попробуйте снова через час");

                    RequestDispatcher dispatcher = request.getRequestDispatcher(pathToErrorPage);
                    dispatcher.forward(request, response);
                }

            } else {
                response.sendRedirect(GO_TO_LOGIN_PAGE_COMMAND);
            }

        } catch (ServiceException e){
            LOGGER.error("error in BuyTour");
            request.setAttribute(ERROR_MSG_ATTRIBUTE, "Серверная ошибка. Попробуйте снова через час");
            response.sendRedirect(pathToErrorPage);
        }
    }
}

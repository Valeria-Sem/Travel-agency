package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.SaleEntity;
import com.epam.travelAgency.entity.UserDetailsEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.service.SaleService;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.ServiceProvider;
import com.epam.travelAgency.service.UserDetailsService;
import com.epam.travelAgency.service.validation.ValidationService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

public class UpdateUserSale implements Command {
    private final Logger LOGGER = Logger.getLogger(UpdateUserSale.class);

    private final String USER_SALE = "userSale";
    private final String SALE_ATTRIBUTE = "sale";
    private final String ERROR_ATTRIBUTE = "errorMsg";
    private final String COMMAND_TO_USER_INFO_PAGE = "controller?command=showuserinfo";
    private final String ID_USER = "id_user";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";
    private final String SERVER_ERROR= "Sorry server error.";
    private final String VALIDATION_ERROR= "Validation error.";
    private final String PATH_TO_USER_INFO_PAGE = "WEB-INF/jsp/error/errorPage.jsp";



    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        int newSale;
        int userId;
        SaleEntity sale;

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        SaleService saleService = serviceProvider.getSaleService();
        ValidationService validationService = serviceProvider.getValidationService();

        try {
            userId = (int) session.getAttribute(ID_USER);
            newSale = Integer.parseInt(request.getParameter(SALE_ATTRIBUTE));

            if(validationService.isSaleValid(String.valueOf(newSale))){
                sale = saleService.updateSaleInfo(userId ,newSale);
                session.setAttribute(USER_SALE, sale);
                response.sendRedirect(COMMAND_TO_USER_INFO_PAGE);

            } else {
                request.setAttribute(ERROR_ATTRIBUTE, VALIDATION_ERROR);
                RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_USER_INFO_PAGE);
                dispatcher.forward(request, response);
            }

        } catch (ServiceException e) {
            LOGGER.error(SERVER_ERROR, e);

            request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR);
            RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_ERROR_PAGE);
            dispatcher.forward(request, response);
        }
    }
}

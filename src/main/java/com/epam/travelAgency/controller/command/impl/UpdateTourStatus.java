package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.SaleEntity;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.TourStatus;
import com.epam.travelAgency.service.SaleService;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.ServiceProvider;
import com.epam.travelAgency.service.TourService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateTourStatus implements Command {
    private final Logger LOGGER = Logger.getLogger(UpdateUserInfo.class);

    private final String TOUR_STATUS = "status";
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
    private final String pathToAdminPage = "controller?command=gotoadminpage";
    private final String pathToUserInfo = "controller?command=showuserinfo";
    private final String ID_TOUR = "id_tour";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        TourStatus status;
        int tourId;

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        TourService tourService = serviceProvider.getTourService();

        try {
            tourId = Integer.parseInt(request.getParameter(ID_TOUR));
            status = TourStatus.valueOf(request.getParameter(TOUR_STATUS));

           // sale = saleService.updateSaleInfo(userId ,newSale);

           // request.setAttribute(errorMessageS, errorMessage);
            tourService.isTourStatusUpdate(tourId, status);
            response.sendRedirect(pathToAdminPage);

        } catch (ServiceException e) {
            LOGGER.error(errorMessage);
        }
    }
}

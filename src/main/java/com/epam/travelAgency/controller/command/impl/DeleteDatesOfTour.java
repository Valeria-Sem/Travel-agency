package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.service.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class DeleteDatesOfTour implements Command {
    private final Logger LOGGER = Logger.getLogger(DeleteDatesOfTour.class);

    private final String GO_DETAILS_PAGE_COMMAND = "controller?command=gotodetailspage&id=";

    private final String TOUR_ID_PARAM = "id_tour";
    private final String ARR_DATE_PARAM = "arr_date";
    private final String DEP_DATE_PARAM = "dep_date";

    private final String ERROR_ATTRIBUTE = "errorMsg";

    private final String SERVER_ERROR= "Sorry, delete dates server error.";
    private final String ERROR_PAGE_PATH = "WEB-INF/jsp/error/errorPage.jsp";

    public DeleteDatesOfTour() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int idTour;
        LocalDate arrDate;
        LocalDate depDate;
        try {
            if (request.getParameter(TOUR_ID_PARAM) != null
                    && request.getParameter(ARR_DATE_PARAM) != null
                    && request.getParameter(DEP_DATE_PARAM) != null) {

                idTour = Integer.parseInt(request.getParameter(TOUR_ID_PARAM));
                arrDate = LocalDate.parse(request.getParameter(ARR_DATE_PARAM));
                depDate = LocalDate.parse(request.getParameter(DEP_DATE_PARAM));

                ServiceProvider serviceProvider = ServiceProvider.getInstance();
                DateTourService dateTourService = serviceProvider.getDateTourService();

                dateTourService.deleteTourDates(idTour, findDateId(arrDate), findDateId(depDate));

                response.sendRedirect(GO_DETAILS_PAGE_COMMAND + idTour);
            }
        } catch (ServiceException e){
            request.setAttribute(ERROR_ATTRIBUTE, SERVER_ERROR);
            request.getRequestDispatcher(ERROR_PAGE_PATH).forward(request, response);

            LOGGER.error(SERVER_ERROR, e);
        }
    }

    private int findDateId(LocalDate date){
        int dateId = 0;
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        DateService dateService = serviceProvider.getDateService();

        try {
            dateId = dateService.getIdByDate(date);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return dateId;
    }
}

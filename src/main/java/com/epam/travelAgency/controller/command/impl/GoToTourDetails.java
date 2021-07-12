package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.HotelEntity;
import com.epam.travelAgency.entity.MealsEntity;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.TransportEntity;
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

public class GoToTourDetails implements Command {
    private final Logger LOGGER = Logger.getLogger(GoToTourDetails.class);

    private final String PATH_TO_DETAILS_PAGE = "WEB-INF/jsp/tours/details/detailsPage.jsp";
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";

    private final String ID_PARAM = "id";
    private final String TOUR_ATTRIBUTE = "tour";
    private final String HOTEL_ATTRIBUTE = "hotel";
    private final String TRANSPORT_ATTRIBUTE = "transport";
    private final String MEALS_ATTRIBUTE = "meals";
    private final String ARR_DATES_ATTRIBUTE = "arrDates";
    private final String DEP_DATES_ATTRIBUTE = "depDates";

    private final String PAGE = "page";
    private final String PAGE_COMMAND = "gotodetailspage";

    private final String ERROR_MSG = "errorMsg";
    private final String SERVER_ERROR_MSG = "Server error. Please come back later";

    public GoToTourDetails() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int tourId;
        TourEntity tour;
        MealsEntity meals;
        HotelEntity hotel;
        TransportEntity transport;
        List<LocalDate> arrivalDates;
        List<LocalDate> departureDates;

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        TourService tourService = serviceProvider.getTourService();
        MealsService mealsService = serviceProvider.getMealsService();
        HotelService hotelService = serviceProvider.getHotelService();
        TransportService transportService = serviceProvider.getTransportService();
        DateTourService dateTourService = serviceProvider.getDateTourService();

        try{

        if(request.getParameter(ID_PARAM) != null){
            tourId = Integer.parseInt(request.getParameter(ID_PARAM));

            tour = tourService.getTourById(tourId);
            meals = mealsService.getMealsById(tour.getIdMeals());
            hotel = hotelService.getHotelById(tour.getIdHotel());
            transport = transportService.getTransportById(tour.getIdTransport());
            arrivalDates = dateTourService.getArrivalDatesByIdTour(tour.getId());
            departureDates = dateTourService.getDepartureDatesByIdTour(tour.getId());

            session.setAttribute(PAGE, PAGE_COMMAND);

            session.setAttribute(TOUR_ATTRIBUTE, tour);
            session.setAttribute(HOTEL_ATTRIBUTE, hotel);
            session.setAttribute(MEALS_ATTRIBUTE, meals);
            session.setAttribute(TRANSPORT_ATTRIBUTE, transport);
            session.setAttribute(ARR_DATES_ATTRIBUTE, arrivalDates);
            session.setAttribute(DEP_DATES_ATTRIBUTE, departureDates);
        }

            RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_DETAILS_PAGE);
            dispatcher.forward(request, response);

        } catch (ServiceException e){
            LOGGER.error(SERVER_ERROR_MSG, e);

            request.setAttribute(ERROR_MSG, SERVER_ERROR_MSG);
            request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
        }
    }
}

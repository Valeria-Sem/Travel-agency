package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.TourDAO;
import com.epam.travelAgency.dao.impl.TourDaoImpl;
import com.epam.travelAgency.entity.TourEntity;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

public class ShowExcursionData implements Command {
    private final Logger LOGGER = Logger.getLogger(ShowChillToursData.class);

    private final String pathToExcursionPage = "controller?command=gotoexcursionpage";
    private final String countryS = "countries";
    private final String category = "Экскурсии";
    private final String arrDateS = "arrivalDate";
    private final String depDateS = "departureDate";
    private final String excursionToursS = "excursionTours";
    private final String errMess = "Registration error";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);

        String country;
        LocalDate arrDate;
        LocalDate depDate;

        country = request.getParameter(countryS);
        arrDate = LocalDate.parse(request.getParameter(arrDateS));
        depDate = LocalDate.parse(request.getParameter(depDateS));


//        ServiceProvider serviceProvider = ServiceProvider.getInstance();
//        UserService userService = serviceProvider.getUserService();
        Set<TourEntity> excursionTours ;//= (Set<TourEntity>) session.getAttribute(chillToursS);

        // chillTours.clear();
//        if(chillTours == null) {
//            ServiceProvider provider = ServiceProvider.getInstance();
//            CategoryService categoryService = provider.getCategoryService();
        TourDAO tourDao = new TourDaoImpl();

        try {
            excursionTours = tourDao.getTourByStartParams(category, country, arrDate, depDate);

            session.setAttribute(excursionToursS, excursionTours);


        } catch (DAOException e) {
            e.printStackTrace();
        }

        response.sendRedirect(pathToExcursionPage);
//        } else{
//            session.removeAttribute(chillToursS);
//
//            TourDAO tourDao = new TourDaoImpl();
//
//            try {
//                chillTours = tourDao.getTourByStartParams(category, country, arrDate, depDate, adults, children);
//
//                session.setAttribute(chillToursS, chillTours);
//
//
//            } catch (DAOException e) {
//                e.printStackTrace();
//            }
//
//        }
    }
}

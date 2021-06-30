package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.dao.CountriesDAO;
import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.TourDAO;
import com.epam.travelAgency.dao.impl.CountriesDaoImp;
import com.epam.travelAgency.dao.impl.TourDaoImpl;
import com.epam.travelAgency.entity.*;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.ServiceProvider;
import com.epam.travelAgency.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class ShowChillToursData implements Command {
    private final Logger LOGGER = Logger.getLogger(ShowChillToursData.class);

    private final String pathToChillPage = "controller?command=gotochillpage";
    private final String countryS = "countries";
    private final String category = "Отпуск";
    private final String adultsS = "adults";
    private final String childrenS = "children";
    private final String arrDateS = "arrivalDate";
    private final String depDateS = "departureDate";
    private final String chillToursS = "chillTours";
    private final String errMess = "Registration error";

    // private final String findUser = "User with the same email was registered yet";

    public ShowChillToursData() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);

        String country;
        int adults;
        int children;
        LocalDate arrDate;
        LocalDate depDate;

        country = request.getParameter(countryS);
        adults = Integer.parseInt(request.getParameter(adultsS));
        children = Integer.parseInt(request.getParameter(childrenS));
//        System.out.println(children = Integer.parseInt(request.getParameter(childrenS)));
        arrDate = LocalDate.parse(request.getParameter(arrDateS));
        depDate = LocalDate.parse(request.getParameter(depDateS));


//        ServiceProvider serviceProvider = ServiceProvider.getInstance();
//        UserService userService = serviceProvider.getUserService();
        Set<TourEntity> chillTours ;//= (Set<TourEntity>) session.getAttribute(chillToursS);

       // chillTours.clear();
//        if(chillTours == null) {
//            ServiceProvider provider = ServiceProvider.getInstance();
//            CategoryService categoryService = provider.getCategoryService();
            TourDAO tourDao = new TourDaoImpl();

            try {
                chillTours = tourDao.getTourByStartParams(category, country, arrDate, depDate, adults, children);

                session.setAttribute(chillToursS, chillTours);


            } catch (DAOException e) {
                e.printStackTrace();
            }

            response.sendRedirect(pathToChillPage);
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

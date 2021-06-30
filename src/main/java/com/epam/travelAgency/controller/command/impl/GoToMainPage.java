package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.dao.CountriesDAO;
import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.TourDAO;
import com.epam.travelAgency.dao.impl.CountriesDaoImp;
import com.epam.travelAgency.dao.impl.TourDaoImpl;
import com.epam.travelAgency.entity.CategoryEntity;
import com.epam.travelAgency.entity.CountriesEntity;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.TourStatus;
import com.epam.travelAgency.service.CategoryService;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.ServiceProvider;
import com.epam.travelAgency.service.validation.impl.ValidationImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToMainPage implements Command {
    private final String pathToMainPage = "WEB-INF/jsp/main/mainPage.jsp";
    private final String locale = "locale";
    private final String lang = "lang";
    private final String toursL = "tours";
    private final String countriesL = "countries";



    public GoToMainPage(){

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter(locale) != null){
            ValidationImpl.userLocale = request.getParameter(locale);
        }
        request.getSession(true).setAttribute(lang, ValidationImpl.userLocale);

        HttpSession session = request.getSession();

        List<TourEntity> hotTours = (List<TourEntity>) session.getAttribute(toursL);
        List<CountriesEntity> countries = (List<CountriesEntity>) session.getAttribute(countriesL);

        if(hotTours == null && countries == null){
//            ServiceProvider provider = ServiceProvider.getInstance();
//            CategoryService categoryService = provider.getCategoryService();
            TourDAO tourDao = new TourDaoImpl();
            CountriesDAO countriesDAO = new CountriesDaoImp();

            try {
                hotTours = tourDao.getTourByStatus(TourStatus.HOT);
                countries = countriesDAO.getAllCountries();

                session.setAttribute(toursL, hotTours);
                session.setAttribute(countriesL, countries);


            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(pathToMainPage);
        dispatcher.forward(request, response);

    }
}

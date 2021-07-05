package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.TourDAO;
import com.epam.travelAgency.dao.impl.TourDaoImpl;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.TourStatus;
import com.epam.travelAgency.service.validation.impl.ValidationImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToChillPage implements Command {
    private final String pathToChillPage = "WEB-INF/jsp/tours/chill/chill.jsp";
    private final String locale = "locale";
    private final String lang = "lang";

    private final String page = "page";
    private final String pageCommand = "gotochillpage";

    public GoToChillPage() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if(request.getParameter(locale) != null){
//            ValidationImpl.userLocale = request.getParameter(locale);
//        }
//        request.getSession(true).setAttribute(lang, ValidationImpl.userLocale);

        HttpSession session = request.getSession();
//
//        List<TourEntity> tours = (List<TourEntity>) session.getAttribute("tours");
//
//        if(tours == null){
////            ServiceProvider provider = ServiceProvider.getInstance();
////            CategoryService categoryService = provider.getCategoryService();
//            TourDAO tourDao = new TourDaoImpl();
//            try {
//                tours = tourDao.getTourByStatus(TourStatus.HOT);
//
//                session.setAttribute("tours", tours);
//
//            } catch (DAOException e) {
//                e.printStackTrace();
//            }
//        }
        session.setAttribute(page, pageCommand);

        RequestDispatcher dispatcher = request.getRequestDispatcher(pathToChillPage);
        dispatcher.forward(request, response);

    }
}

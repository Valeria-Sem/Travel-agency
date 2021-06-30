package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.service.validation.impl.ValidationImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToShoppingPage implements Command {
    private final String pathToShoppingPage = "WEB-INF/jsp/tours/shopping/shopping.jsp";
    private final String locale = "locale";
    private final String lang = "lang";

    public GoToShoppingPage() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter(locale) != null){
            ValidationImpl.userLocale = request.getParameter(locale);
        }
        request.getSession(true).setAttribute(lang, ValidationImpl.userLocale);

//        HttpSession session = request.getSession();
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
        RequestDispatcher dispatcher = request.getRequestDispatcher(pathToShoppingPage);
        dispatcher.forward(request, response);

    }
}

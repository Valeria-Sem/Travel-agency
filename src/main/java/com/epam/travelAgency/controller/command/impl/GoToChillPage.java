package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.TourDAO;
import com.epam.travelAgency.dao.impl.TourDaoImpl;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.TourStatus;
import com.epam.travelAgency.service.validation.impl.ValidationImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToChillPage implements Command {
    private final String PATH_TO_CHILL_PAGE = "WEB-INF/jsp/tours/chill/chill.jsp";

    private final String PAGE = "page";
    private final String PAGE_COMMAND = "gotochillpage";

    private final String ERROR_MSG = "errorMsg";

    public GoToChillPage() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.setAttribute(PAGE, PAGE_COMMAND);

        RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_TO_CHILL_PAGE);
        dispatcher.forward(request, response);

    }
}

package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowWrongModal implements Command {
    private final String WRONG_MODAL_PATH = "WEB-INF/jsp/wrongModal/wrongModal.jsp";

    public ShowWrongModal(){

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(WRONG_MODAL_PATH);
        dispatcher.forward(request, response);
    }

}

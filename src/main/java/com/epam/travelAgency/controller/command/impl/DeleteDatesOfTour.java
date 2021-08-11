package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteDatesOfTour implements Command {

    public DeleteDatesOfTour() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}

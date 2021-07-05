package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.service.validation.impl.ValidationImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeLanguage implements Command {
    private final String locale = "locale";
    private final String lang = "lang";
    private final String page = "page";
    private final String path = "controller?command=";

    public ChangeLanguage() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getParameter(locale) != null){
            ValidationImpl.userLocale = request.getParameter(locale);
        }
        request.getSession(true).setAttribute(lang, ValidationImpl.userLocale);

        String command = (String) request.getSession().getAttribute(page);
        response.sendRedirect(path + command);
    }
}

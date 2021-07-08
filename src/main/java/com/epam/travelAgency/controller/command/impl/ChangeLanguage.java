package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.service.validation.impl.ValidationImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeLanguage implements Command {
    private final Logger LOGGER = Logger.getLogger(ChangeLanguage.class);

    private final String LOCALE = "locale";
    private final String LANG = "lang";
    private final String PAGE = "page";
    private final String PATH = "controller?command=";
    private final String LANG_ERROR_MSG = "Some problems with changing language";

    public ChangeLanguage() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            if (request.getParameter(LOCALE) != null) {
                ValidationImpl.userLocale = request.getParameter(LOCALE);
            }
            request.getSession(true).setAttribute(LANG, ValidationImpl.userLocale);

            String command = (String) request.getSession().getAttribute(PAGE);
            response.sendRedirect(PATH + command);

        } catch (Exception e){
            LOGGER.error(LANG_ERROR_MSG, e);
        }
    }
}

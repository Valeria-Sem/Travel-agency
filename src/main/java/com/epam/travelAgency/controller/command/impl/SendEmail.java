package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.TourEntity;
import com.epam.travelAgency.entity.UserEntity;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

public class SendEmail implements Command {
    private final String PATH_TO_ERROR_PAGE = "WEB-INF/jsp/error/errorPage.jsp";
    private final String PATH_TO_BILL = "controller?command=showbill";

    private final String PROPERTIES = "mail.properties";
    private final String EMAIL_NAME = "happy.tour.minsk";
    private final String CURRENT_USER = "current_user";
    private final String TEXT = "Вы успешно приобрели тур - ";
    private final String END_TEXT = "$ \nПросьба явиться в офис по адресу - пр.Машерова 11 для заключения договора." +
            "\n С уважением Ваш Happy Tour :)";
    private final String DATES = "\nДаты тура : ";
    private final String PRICE = "\nСумма с учётом скидки : ";
    private final String TITLE = "Подтверждение оплаты тура";
    private final String TOUR_ATTRIBUTE = "tour";
    private final String EMAIL_PASSWORD = "happyTourMinsk";
    private final String DATES_PARAM = "dates";
    private final String ERROR_MSG = "errorMsg";
    private final String DISCOUNT_PRICE = "discountPrice";

//    private final String PAGE = "page";
//    private final String PATH = "controller?command=";

    public SendEmail(){

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
  //      session.setAttribute(page, pageCommand);
        TourEntity tour;
        UserEntity user;
        String dates;

        final Properties properties = new Properties();
        properties.load(SendEmail.class.getClassLoader().getResourceAsStream(PROPERTIES));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);

        try {
            user = (UserEntity) session.getAttribute(CURRENT_USER);
            tour = (TourEntity) session.getAttribute(TOUR_ATTRIBUTE);
            double price = (double) session.getAttribute(DISCOUNT_PRICE);

            dates = (String) session.getAttribute(DATES_PARAM);
            String[] fromToDates = dates.split(";");

            message.setFrom(new InternetAddress(EMAIL_NAME));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            message.setSubject(TITLE);
            message.setText(TEXT + tour.getName() + DATES + fromToDates[0] + " - " + fromToDates[1] +
                    PRICE + price + END_TEXT);

            Transport tr = mailSession.getTransport();
            tr.connect(null, EMAIL_PASSWORD);
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();

//            String command = (String) request.getSession().getAttribute(PAGE);
            response.sendRedirect(PATH_TO_BILL);

        } catch (MessagingException e) {
            e.printStackTrace();
            request.setAttribute(ERROR_MSG ,"Some troubles with sending bill to your email.");

            request.getRequestDispatcher(PATH_TO_ERROR_PAGE).forward(request, response);
        }
    }
}

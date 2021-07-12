package com.epam.travelAgency.controller.command.impl;

import com.epam.travelAgency.controller.command.Command;
import com.epam.travelAgency.entity.CategoryEntity;
import com.epam.travelAgency.entity.UserDetailsEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.WalletEntity;
import com.epam.travelAgency.service.CategoryService;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.ServiceProvider;
import com.epam.travelAgency.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ShowCategories implements Command {
    private final String PATH_TO_MAIN_PAGE = "controller?command=gotomainpage";
    private final String CATEGORIES = "categories";


    public ShowCategories(){

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Iterable<CategoryEntity> categories = (Iterable<CategoryEntity>) session.getAttribute(CATEGORIES);

        if(categories == null){
            ServiceProvider provider = ServiceProvider.getInstance();
            CategoryService categoryService = provider.getCategoryService();

            try {
                categories = categoryService.getAllCategories();

                session.setAttribute(PATH_TO_MAIN_PAGE, categories);

                response.sendRedirect(PATH_TO_MAIN_PAGE);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }

    }
}

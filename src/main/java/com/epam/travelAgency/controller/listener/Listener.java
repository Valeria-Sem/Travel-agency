package com.epam.travelAgency.controller.listener;

import com.epam.travelAgency.dao.pool.ConnectionPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener {
    public static final String userNameDB = "root";
    public static final String passwordDB = "Lera";
    public static final String urlDB = "jdbc:mysql://localhost:3306/travel_agency";
    public static final String driver = "com.mysql.cj.jdbc.Driver";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ConnectionPool.getInstance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
      //  ConnectionPool.getInstance().closeConnection();
    }

}

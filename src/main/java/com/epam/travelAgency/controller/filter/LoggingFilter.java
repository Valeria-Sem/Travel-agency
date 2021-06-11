package com.epam.travelAgency.controller.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class LoggingFilter implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context= filterConfig.getServletContext();
        this.context.log("RequestLoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        Enumeration<String> params = req.getParameterNames();
        while(params.hasMoreElements()) {
            String name = params.nextElement();
            String value = servletRequest.getParameter(name);
            this.context.log(req.getRemoteAddr()+"::Reguest Params::{"+name+"="+value+"}");
        }
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                this.context.log(req.getRemoteAddr()+":: Cookie :: {"+cookie.getName()+","+cookie.getValue()+"}");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

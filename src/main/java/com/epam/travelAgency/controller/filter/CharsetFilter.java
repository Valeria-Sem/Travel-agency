package com.epam.travelAgency.controller.filter;

import com.epam.travelAgency.service.validation.impl.ValidationImpl;

import javax.servlet.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CharsetFilter implements Filter {
    private String encoding;
    private ServletContext context;
    private final String characterEncoding = "characterEncoding";
    private final String contextLog = "Charset was set.";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter(characterEncoding);
        context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        context.log(contextLog);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

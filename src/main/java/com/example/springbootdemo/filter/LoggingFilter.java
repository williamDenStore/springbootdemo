package com.example.springbootdemo.filter;

import jakarta.servlet.*;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Logger;
@Component
@Controller
@Service
@Order(1)
public class LoggingFilter implements Filter {
    org.slf4j.Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("incoming request for: "+ servletRequest.getServletContext().getContextPath());

        filterChain.doFilter(servletRequest,servletResponse);
    }
}

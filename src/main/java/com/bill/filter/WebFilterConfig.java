package com.bill.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/**", filterName = "WebFilter")
public class WebFilterConfig implements Filter {
    private final String name = "webFilter";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("[Filter] WebFilter {} handle before", name);
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("[Filter] WebFilter {} handle after", name);
    }
}

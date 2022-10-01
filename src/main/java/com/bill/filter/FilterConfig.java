package com.bill.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean customFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        //設置自訂Filter
        registrationBean.setFilter(new CustomFilter());

        //攔截規則
        registrationBean.addUrlPatterns("/**/demo");

        //初始化參數
        registrationBean.addInitParameter("name", "customFilter");

        registrationBean.setName("CustomFilter");
        registrationBean.setOrder(1);

        return registrationBean;

    }
}

@Slf4j
class CustomFilter implements Filter {
    private String name;

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
        name = filterConfig.getInitParameter("name");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("[Filter] CustomFilter {} doFilter() before", name);
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("[Filter] CustomFilter {} doFilter() after", name);
    }
}

package com.bill.interceptor.hanlderinterceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class HandlerInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomHandlerInterceptor()).addPathPatterns("/**/demo");
    }
}

@Slf4j
class CustomHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod method = (HandlerMethod) handler;
        log.info("[HandlerInterceptor] CustomHandlerInterceptor preHandle(), {}", method.getMethod().getName());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod method = (HandlerMethod) handler;
        log.info("[HandlerInterceptor] CustomHandlerInterceptor postHandle(), {}", method.getMethod().getName());

//        response.getOutputStream().write("append content".getBytes());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerMethod method = (HandlerMethod) handler;
        log.info("[HandlerInterceptor] CustomHandlerInterceptor afterCompletion(), {}", method.getMethod().getName());
    }
}

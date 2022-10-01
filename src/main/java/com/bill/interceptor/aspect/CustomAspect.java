package com.bill.interceptor.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Slf4j
public class CustomAspect {
    @Pointcut("execution(* com.bill.controller..*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        log.info("[Aspect] CustomAspect before()");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        log.info("[Aspect] CustomAspect after()");
    }

//    @Around("pointcut()")
//    public void around() {
//        log.info("[Aspect] CustomAspect around()");
//    }

    @AfterReturning(pointcut = "pointcut()", returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret) throws Throwable {
        log.info("[Aspect] CustomAspect afterReturning()");
    }

    @AfterThrowing(pointcut = "pointcut()", throwing="ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) throws Throwable {
        log.info("[Aspect] CustomAspect afterThrowing()");
    }
}

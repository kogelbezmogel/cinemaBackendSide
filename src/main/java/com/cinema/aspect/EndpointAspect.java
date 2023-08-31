package com.cinema.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EndpointAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(EndpointAspect.class);

    @Before("execution(* com.cinema.controller.*.*(..))")
    public void beforeAdvice(){
        LOGGER.info("Function from controller moved");
    }

}

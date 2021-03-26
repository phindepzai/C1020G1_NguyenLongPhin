package com.binzet.concern;

import com.binzet.controller.BookingController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
@Aspect
public class Logger {
    public static String bookName;
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

    @After("execution(* com.binzet.service.BookService.giveBookBack(..))")
    public void afterBorrowing(){
        LOGGER.info("Give back "+bookName);
    }

    @After("execution(* com.binzet.service.BookService.rentBook(..))")
    public void afterReturning(){
        LOGGER.info("Rent book "+bookName);
    }
}

package com.binzet.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class Logger {
    public void error() {
        System.out.println("[CMS] ERROR!");
    }
    @After("execution(public * com.binzet.service.CustomerService.findAll(..))")
    public void log() {
        System.out.println("after findAll");
    }
    @AfterThrowing(pointcut = "execution(public * com.binzet.service.CustomerService.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
    }

}

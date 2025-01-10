package com.sazonov.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyLoggingAspect {


    @Around("execution(* com.sazonov.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String methodName = proceedingJoinPoint.getSignature().getName();

        System.out.println("Begin of "+ methodName);
        Object targetMethodResult =proceedingJoinPoint.proceed();
        System.out.println("End of "+ methodName);
        return targetMethodResult;
    }
}

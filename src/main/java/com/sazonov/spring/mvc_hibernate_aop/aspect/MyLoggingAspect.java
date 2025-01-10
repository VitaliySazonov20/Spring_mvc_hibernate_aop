package com.sazonov.spring.mvc_hibernate_aop.aspect;

import jdk.internal.classfile.MethodSignature;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class MyLoggingAspect {

    @Around("execution(* com.sazonov.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.signatureString();

        System.out.println("Begin of "+ methodName);
        Object targetMethodResult =proceedingJoinPoint.proceed();
        System.out.println("End of "+ methodName);
        return targetMethodResult;
    }
}

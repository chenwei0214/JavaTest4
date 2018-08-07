package com.hand.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void beforeInsertFilmEvent(JoinPoint joinPoint) {
        System.out.println("\n======Before Insert Film Data======");
    }

    public void afterInsertFilmEvent(JoinPoint joinPoint, Object ret) {
        System.out.println("======After Insert Film Data======\n");
    }

    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("\n=====BeforeInsertFilmEvent========");
        //手动执行目标方法
        Object obj = joinPoint.proceed();

        System.out.println("=====AfterInsertFilmEvent=========\n");
        return obj;
    }

    public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("抛出异常通知 ： " + e.getMessage());
    }


    public void myAfter(JoinPoint joinPoint) {

        System.out.println(joinPoint.getSignature());

        System.out.println(Arrays.asList(joinPoint.getArgs()));
        System.out.println(joinPoint.getTarget().getClass());
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("最终通知");
    }

}

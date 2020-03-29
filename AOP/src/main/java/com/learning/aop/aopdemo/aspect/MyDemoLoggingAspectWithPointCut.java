package com.learning.aop.aopdemo.aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
//@Component
public class MyDemoLoggingAspectWithPointCut {

    //pointcut declaration
    @Pointcut("execution (* com.learning.aop.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){ }

    @Pointcut("execution (* com.learning.aop.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution (* com.learning.aop.aopdemo.dao.*.set*(..))")
    public void setter(){}

    //using poincut declaration
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println();
        System.out.println("->>>>>>>>>> common logging before " +
                "any method called from dao package");
    }

    //reusing poincut declaration
    @Before("forDaoPackage()")
    public void performAPIAnalytics(){
        System.out.println();
        System.out.println("->>>>>>>>>> performing API analytics " +
                "for sny method of any class called from dao package");
    }

    //combining pointcuts
    @Before("forDaoPackage() && !(getter() && setter())")
    public void runOnMethodsExceptGetterAndSetter(){
        System.out.println();
        System.out.println("->>>>>>>> run before any method except getter and setter from dao package");
    }

}

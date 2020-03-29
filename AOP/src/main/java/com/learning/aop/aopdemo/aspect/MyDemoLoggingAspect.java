package com.learning.aop.aopdemo.aspect;

import org.aspectj.lang.annotation.Before;

//@Aspect
//@Component
public class MyDemoLoggingAspect {

    //this is where we add advices
    // pointcut expression
    // ("execution (access modifier ? return type className ? method name parameter ? throws ?))

//    @Before("execution (public void com.learning.aop.aopdemo.dao.AccountDao.addAccount())")
//    public void beforeAddAccountAdvice(){
//        System.out.println();
//        System.out.println(">>>>>>>>> Executing @Before advice on method()");
//    }

//    @Before("execution (public void add*())")
//    public void beforeAnyAddMethod(){
//        System.out.println();
//        System.out.println(">>>>>>>>> Executing before any method starting with name add");
//    }

//    @Before("execution (* add*(com.learning.aop.aopdemo.dao.Account))")
//    public void beforeAddAccountAdvice(){
//        System.out.println();
//        System.out.println(">>>>>>>>> Executing @Before advice on method(with only 1 param)");
//    }

//    @Before("execution (* add*(com.learning.aop.aopdemo.dao.Account, ..))")
//    public void beforeAddAccountAdvice2(){
//        System.out.println();
//        System.out.println(">>>>>>>>> Executing @Before advice on method(with more than 1 params or 1 param)");
//    }

//    @Before("execution (* add*(..))")
//    public void beforeAddAccountAdvice2(){
//        System.out.println();
//        System.out.println(">>>>>>>>> Executing @Before advice on method starting with add(with any no of params)");
//    }

    @Before("execution (* com.learning.aop.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice2(){
        System.out.println();
        System.out.println(">>>>>>>>> Executing @Before advice on a package with all methods in the package" +
                "(with zero or more parameters)");
    }

}

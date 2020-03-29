package com.learning.aop.aopdemo.orderedaspects.pointcuts;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PoincutExpressions {

    @Pointcut("execution (* com.learning.aop.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){ }

    @Pointcut("execution (* com.learning.aop.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution (* com.learning.aop.aopdemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() && setter())")
    public void methodsExceptGetterAndSetter(){}

}

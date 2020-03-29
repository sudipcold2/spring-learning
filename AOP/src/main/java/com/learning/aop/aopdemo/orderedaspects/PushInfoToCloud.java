package com.learning.aop.aopdemo.orderedaspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(100)
public class PushInfoToCloud {

    @Before("com.learning.aop.aopdemo.orderedaspects.pointcuts.PoincutExpressions.methodsExceptGetterAndSetter()")
    public void loggingBeforeMethodExecution(){
        System.out.println("->>>>>>>>>> Push info to cloud before " +
                "any method (Except getter/setter) of any class, called from dao package");
    }

}

package com.learning.aop.aopdemo.orderedaspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(10)
public class PerformAnalyticsAspect {

    @Before("com.learning.aop.aopdemo.orderedaspects.pointcuts.PoincutExpressions.methodsExceptGetterAndSetter()")
    public void performAPIAnalytics(){
        System.out.println("->>>>>>>>>> performing API analytics " +
                "for any method (Except getter/setter) of any class called from dao package");
    }
}

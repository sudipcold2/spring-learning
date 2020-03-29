package com.sudip.learn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    //pointcuts
    @Pointcut("execution(* com.sudip.learn.controller.*.*(..))")
    private void forControllerPackage(){ }

    @Pointcut("execution(* com.sudip.learn.dao.*.*(..))")
    private void forDaoPackage(){ }

    @Pointcut("execution(* com.sudip.learn.service.*.*(..))")
    private void forServicePackage(){ }

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void beforeMethodCall(JoinPoint joinPoint){
        logger.info(">>>>>>>> Executing before method execution");
        logger.info("Method is " + joinPoint.getSignature().toString());

        for(Object arg : joinPoint.getArgs()){
            logger.info(">>>>>>>> Argument :: " + arg.toString());
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturningMethods(JoinPoint theJoinPoint, Object result){
        logger.info("<====== Executing after returning from method execution");
        logger.info("Method is " + theJoinPoint.getSignature().toString());

        logger.info("<====== Result is :: " + result);
    }
}

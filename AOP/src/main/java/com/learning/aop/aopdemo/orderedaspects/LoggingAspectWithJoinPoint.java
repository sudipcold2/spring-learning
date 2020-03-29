package com.learning.aop.aopdemo.orderedaspects;

import com.learning.aop.aopdemo.dao.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(-1)
public class LoggingAspectWithJoinPoint {

    //using join point to sniff incoming method data or signature
    @Before("com.learning.aop.aopdemo.orderedaspects.pointcuts.PoincutExpressions.methodsExceptGetterAndSetter()")
    public void loggingBeforeMethodExecution(JoinPoint joinPoint){
        System.out.println("->>>>>>>>>> Intial logging before running" +
                "any method (Except getter/setter) of any class called from dao package");
        System.out.println();
        System.out.println("---------------Join point------------");
        Signature signature = joinPoint.getSignature();
        System.out.println("method signature :: "+ signature);

        //get passed arguments passed to the calling function
        System.out.println();
        Object[] args = joinPoint.getArgs();
        for(Object arg : args){
            System.out.println(arg);
        }

        System.out.println();
        System.out.println("------------end------------");
    }

    //After returning advice for findAccounts
    // returning value name (result) must match with name of parameter in the function which holds
    // the returning values
    //modify return data (post processing the data and sending it to the caller) with After return advice
    //Be careful
    @AfterReturning(
            pointcut = "execution(* com.learning.aop.aopdemo.dao.AccountDao.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinpoint, List<Account> result){

        String method = theJoinpoint.getSignature().toShortString();
        System.out.println(">>>>>>>>>>> Executing @AfterReturning on method ::"+ method);

        System.out.println(">>>>>>>>>>> Actual Result is ::" + result);

        if(!result.isEmpty()){
            Account tempAccount = result.get(0);
            tempAccount.setName("Prateek");
        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.learning.aop.aopdemo.dao.AccountDao.findAccountsException(..))",
            throwing = "throwEx"
    )
    public void afterThrowingFindAccountsExceptionAdvice(JoinPoint theJoinpoint, Exception throwEx){
        String method = theJoinpoint.getSignature().toShortString();
        System.out.println(">>>>>>>>>>> Executing @AfterThrowing on method ::" + method);

        System.out.println("Exception from Advice is ::" + throwEx);
    }

    //works like finally (success or exception doesn't matter)
    //run before throwing the exception from any method
    @After("execution(* com.learning.aop.aopdemo.dao.AccountDao.findAccountsException(..))")
    public void afterFindAccountsExceptionAdvice(JoinPoint theJoinPoint){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println(">>>>>>>>>>> Executing @AfterThrowing on method ::" + method);

        System.out.println(">>>>>>>>>>> After(finally) advice");
    }


    @Around("execution(* com.learning.aop.aopdemo.service.*.getFortune(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println(">>>>>>>>>>> Executing @Around on method ::" + method);

        long start = System.currentTimeMillis();

        Object result = null;

        try{
            result = proceedingJoinPoint.proceed();

        }catch (Exception e){
            System.out.println("!!!! Exception occured and handled in advice");
            result = "Default value because an Exception has occurred";

            //you can rethrow exception so that caller will decide on what to do
            //throw e;
        }

        long end = System.currentTimeMillis();

        System.out.println("<<<<<<<< Time taken to execute the function() is : "
                + (end-start) / 1000 + " secs");

        return result;
    }

}

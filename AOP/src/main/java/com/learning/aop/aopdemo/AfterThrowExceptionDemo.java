package com.learning.aop.aopdemo;

import com.learning.aop.aopdemo.dao.Account;
import com.learning.aop.aopdemo.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowExceptionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        List<Account> accounts = null;
        try{
            accounts = accountDao.findAccountsException(true);
        }catch (Exception e){
            System.out.println("Exception handled from main program is ::" + e);
        }

        System.out.println("Accounts :- " + accounts);

        applicationContext.close();

    }
}

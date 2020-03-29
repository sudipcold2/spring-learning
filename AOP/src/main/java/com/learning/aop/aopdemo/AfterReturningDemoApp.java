package com.learning.aop.aopdemo;

import com.learning.aop.aopdemo.dao.Account;
import com.learning.aop.aopdemo.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);

        List<Account> accounts = accountDao.findAccounts();

        System.out.println("Main program: AfterReturningDemoApp ----------------------");
        System.out.println(accounts);

        applicationContext.close();
    }
}

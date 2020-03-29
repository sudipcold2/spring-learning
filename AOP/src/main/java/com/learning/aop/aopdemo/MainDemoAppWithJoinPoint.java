package com.learning.aop.aopdemo;

import com.learning.aop.aopdemo.dao.Account;
import com.learning.aop.aopdemo.dao.AccountDao;
import com.learning.aop.aopdemo.dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoAppWithJoinPoint {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);

        MembershipDao membershipDao = applicationContext.getBean("membershipDao", MembershipDao.class);

        Account account = new Account();
        account.setName("Sudip");
        account.setId(10111);

        System.out.println();

        accountDao.addAccount(account);

        System.out.println();

        applicationContext.close();
    }
}

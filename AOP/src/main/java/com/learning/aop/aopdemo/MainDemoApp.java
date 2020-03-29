package com.learning.aop.aopdemo;

import com.learning.aop.aopdemo.dao.Account;
import com.learning.aop.aopdemo.dao.AccountDao;
import com.learning.aop.aopdemo.dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);

        MembershipDao membershipDao = applicationContext.getBean("membershipDao", MembershipDao.class);

        Account account = new Account();
        accountDao.addAccount(account);

        //accountDao.addAccount(account, true);

        System.out.println();

        accountDao.doWork();

        System.out.println();

        membershipDao.addSillyAccount();

        System.out.println();

        applicationContext.close();

    }
}

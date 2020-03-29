package com.learning.aop.aopdemo;

import com.learning.aop.aopdemo.dao.Account;
import com.learning.aop.aopdemo.dao.AccountDao;
import com.learning.aop.aopdemo.dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoAppWithPointCut {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);

        MembershipDao membershipDao = applicationContext.getBean("membershipDao", MembershipDao.class);

        Account account = new Account();
        account.setId(1);
        account.setName("Sudip");

        accountDao.addAccount(account);
        accountDao.setAccount(account);

        //accountDao.addAccount(account, true);

        System.out.println();

        accountDao.doWork();

        System.out.println();

        membershipDao.addSillyAccount();

        System.out.println();

        System.out.println("Executing getter method from a Spring bean " + accountDao.getAccount());

        System.out.println();

        applicationContext.close();
    }
}

package com.learning.aop.aopdemo;

import com.learning.aop.aopdemo.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoAppWithOrderingAspects {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);

        System.out.println();

        accountDao.doWork();

        System.out.println();

        applicationContext.close();
    }
}

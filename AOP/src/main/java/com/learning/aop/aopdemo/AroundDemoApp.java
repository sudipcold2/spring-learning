package com.learning.aop.aopdemo;

import com.learning.aop.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService =
                applicationContext.getBean("trafficFortuneService", TrafficFortuneService.class);

        String fortune = trafficFortuneService.getFortune();

        System.out.println("------ From Main Program" + fortune);

        applicationContext.close();
    }
}

package com.example.springlearnioc.springiocwithjavaconfig;

import com.example.springlearnioc.springiocwithjavaconfig.helper.Coach;
import com.example.springlearnioc.springiocwithjavaconfig.helper.SwimCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("javaconfigannotation.xml");

        //Constructor Injection
        System.out.println("-----------------------------------------------------------------");
        Coach coach = applicationContext.getBean("rugbyCoach", Coach.class);
        System.out.println(coach.giveWorkOutDetails());
        System.out.println(coach.dailyFortune());

        System.out.println("-----------------------------------------------------------------");

        //setter method Injection
        Coach ttCoach = applicationContext.getBean("tableTennisCoach", Coach.class);
        System.out.println(ttCoach.giveWorkOutDetails());
        System.out.println(ttCoach.dailyFortune());

        System.out.println("-----------------------------------------------------------------");

        //field method Injection
        Coach fCoach = applicationContext.getBean("footballCoach", Coach.class);
        System.out.println(fCoach.giveWorkOutDetails());
        System.out.println(fCoach.dailyFortune());

        System.out.println("-----------------------------------------------------------------");

        //any method Injection
        Coach kCoach = applicationContext.getBean("kustiCoach", Coach.class);
        System.out.println(kCoach.giveWorkOutDetails());
        System.out.println(kCoach.dailyFortune());

        //use properties file
        System.out.println("-----------------------------------------------------------------");
        SwimCoach swimCoach = applicationContext.getBean("swimCoach", SwimCoach.class);
        System.out.println(swimCoach.giveWorkOutDetails());
        System.out.println(swimCoach.dailyFortune());
        System.out.println(swimCoach.getName());
        System.out.println(swimCoach.getEmailid());

        applicationContext.close();


    }
}

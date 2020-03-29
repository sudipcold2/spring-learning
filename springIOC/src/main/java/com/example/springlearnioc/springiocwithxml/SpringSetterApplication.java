package com.example.springlearnioc.springiocwithxml;

import com.example.springlearnioc.springiocwithxml.helperclasses.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSetterApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationcontext.xml");
        CricketCoach coach = applicationContext.getBean("cricketCoach", CricketCoach.class);

        System.out.println(coach.getWorkoutdetails());
        System.out.println(coach.giveFortune());
        System.out.println(coach.getEmail());
        System.out.println(coach.getTeamName());

        applicationContext.close();
    }
}
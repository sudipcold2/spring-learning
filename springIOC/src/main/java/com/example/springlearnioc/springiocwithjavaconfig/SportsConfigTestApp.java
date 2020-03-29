package com.example.springlearnioc.springiocwithjavaconfig;

import com.example.springlearnioc.springiocwithjavacodeonly.SportConfig;
import com.example.springlearnioc.springiocwithjavaconfig.helper.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SportsConfigTestApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SportConfig.class);

        Coach coach = applicationContext.getBean("tableTennisCoach", Coach.class);

        System.out.println(coach.giveWorkOutDetails());
        System.out.println(coach.dailyFortune());

        applicationContext.close();
    }
}

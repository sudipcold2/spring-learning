package com.example.springlearnioc.springiocwithjavacodeonly;

import com.example.springlearnioc.springiocwithjavacodeonly.helper.SwimCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SportsConfigTestApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SportConfig.class);

        SwimCoach coach = applicationContext.getBean("swimCoach", SwimCoach.class);

        System.out.println(coach.giveWorkOutDetails());
        System.out.println(coach.dailyFortune());
        System.out.println(coach.getEmail());
        System.out.println(coach.getTeamName());

        applicationContext.close();
    }
}

package com.example.springlearnioc.springiocwithjavaconfig;
import com.example.springlearnioc.springiocwithjavaconfig.helper.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTestApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("javaconfigannotation.xml");

        Coach footballCoach1 = applicationContext.getBean("footballCoach", Coach.class);
        Coach footballCoach2 = applicationContext.getBean("footballCoach", Coach.class);

        System.out.println("footballcoach 1 :" + footballCoach1.hashCode() + "  "
                + "footballCoach 2: " + footballCoach2.hashCode());

        Coach ttCoach = applicationContext.getBean("tableTennisCoach", Coach.class);

        applicationContext.close();
    }
}

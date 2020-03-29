package com.example.springlearnioc.springiocwithxml;

import com.example.springlearnioc.springiocwithxml.helperclasses.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beanscope.xml");

        //scope = singleton
        Coach theCoach = applicationContext.getBean("myCoach", Coach.class);
        Coach alphaCoach = applicationContext.getBean("myCoach", Coach.class);

        boolean result = (theCoach == alphaCoach);

        System.out.println("Pointing to the same object : " + result);
        System.out.println("Memory location of theCoach object" + theCoach);
        System.out.println("Memory location of alphaCoach object" + alphaCoach);

        Coach theCoach2 = applicationContext.getBean("myCoach2", Coach.class);
        Coach alphaCoach2 = applicationContext.getBean("myCoach2", Coach.class);

        //scope = provided
        boolean result2 = (theCoach2 == alphaCoach2);

        System.out.println("Pointing to the same object : " + result2);
        System.out.println("Memory location of theCoach object" + theCoach2);
        System.out.println("Memory location of alphaCoach object" + alphaCoach2);

        applicationContext.close();
    }
}

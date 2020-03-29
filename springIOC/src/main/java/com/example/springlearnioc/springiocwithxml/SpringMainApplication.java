package com.example.springlearnioc.springiocwithxml;

import com.example.springlearnioc.springiocwithxml.helperclasses.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMainApplication {

    public static void runApp() {
        //create container
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationcontext.xml");

        //retrieve spring bean from container (bean id, interface name)
        Coach ch = applicationContext.getBean("myCoach", Coach.class);

        //use object
        System.out.println(ch.getWorkoutdetails());
        System.out.println(ch.giveFortune());

        //close container
        applicationContext.close();;
    }

    public static void main(String[] args) {
        runApp();
    }
}

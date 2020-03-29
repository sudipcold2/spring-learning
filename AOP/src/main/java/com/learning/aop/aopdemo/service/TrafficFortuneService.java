package com.learning.aop.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(){

        //simulate delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Expect Heavy traffic this morning";
    }

    public String getFortune(boolean tripWire){
        if(tripWire){
            throw new RuntimeException("Exception coming from getFortune(tripwire)");
        }

        return getFortune();
    }
}

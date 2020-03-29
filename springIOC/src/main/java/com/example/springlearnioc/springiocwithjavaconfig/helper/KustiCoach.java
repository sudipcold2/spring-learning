package com.example.springlearnioc.springiocwithjavaconfig.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class KustiCoach implements Coach{

    private FortuneService fortuneService;

    @Autowired
    @Qualifier("dbFortune")
    public void injectFortuneService(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    @Override
    public String giveWorkOutDetails() {
        return "practice dhobi pachar for 1hr";
    }

    @Override
    public String dailyFortune() {
        return fortuneService.giveFortune();
    }
}

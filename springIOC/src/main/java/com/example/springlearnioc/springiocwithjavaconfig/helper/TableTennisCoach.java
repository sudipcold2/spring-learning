package com.example.springlearnioc.springiocwithjavaconfig.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class TableTennisCoach implements Coach {

    private FortuneService fortuneService;

    @Autowired
    @Qualifier("dbFortune")
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String giveWorkOutDetails() {
        return "practice backhand for 1 hr";
    }

    @Override
    public String dailyFortune() {
        return fortuneService.giveFortune();
    }

    @PostConstruct
    public void afterInitializeBean(){
        System.out.println("after Bean initialization");
    }

    @PreDestroy()
    public void afterBeanDestoyed(){
        System.out.println("before bean got destroyed !!");
    }
}
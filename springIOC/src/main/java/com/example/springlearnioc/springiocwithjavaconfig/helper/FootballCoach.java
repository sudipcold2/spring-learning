package com.example.springlearnioc.springiocwithjavaconfig.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FootballCoach implements Coach{

    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

    @Override
    public String giveWorkOutDetails() {
        return "shoot at goal post up to 100 times";
    }

    @Override
    public String dailyFortune() {
        return fortuneService.giveFortune();
    }

}

package com.example.springlearnioc.springiocwithjavaconfig.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {

    @Autowired
    @Qualifier("dbFortune")
    private FortuneService fortuneService;

    @Value("${data.emailid}")
    private String emailid;

    @Value("${data.name}")
    private String name;

    @Override
    public String giveWorkOutDetails() {
        return "do backstroke for 30min";
    }

    @Override
    public String dailyFortune() {
        return fortuneService.giveFortune();
    }


    public String getEmailid() {
        return emailid;
    }

    public String getName() {
        return name;
    }
}

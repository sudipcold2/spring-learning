package com.example.springlearnioc.springiocwithjavaconfig.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("rugbyCoach")
@Component
public class RugbyCoach implements Coach {

    private FortuneService fortuneService;

    @Autowired
    //Qualifier applicable to only constructor arguments
    public RugbyCoach(@Qualifier("dbFortune")FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String giveWorkOutDetails() {
        return "wrestle 3 players for 15 min";
    }

    @Override
    public String dailyFortune() {
        return fortuneService.giveFortune();
    }

}

package com.example.springlearnioc.springiocwithjavacodeonly.helper;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${prop.email}")
    private String email;

    @Value("${prop.team}")
    private String teamName;

    public String getEmail() {
        return email;
    }

    public String getTeamName() {
        return teamName;
    }

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String giveWorkOutDetails() {
        return "Swim 100 mtr";
    }

    @Override
    public String dailyFortune() {
        return fortuneService.giveFortune();
    }
}

package com.example.springlearnioc.springiocwithxml.helperclasses;

public class CricketCoach implements Coach {

    //declare dependency as a private field
    private FortuneService fortuneService;

    private String email;
    private String teamName;

    public String getEmail() {
        return email;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    //add setter method of dependency field
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getWorkoutdetails() {
        return "practice balling in the nets for 30 mins";
    }

    @Override
    public String giveFortune() {
        return fortuneService.getFortune();
    }
}

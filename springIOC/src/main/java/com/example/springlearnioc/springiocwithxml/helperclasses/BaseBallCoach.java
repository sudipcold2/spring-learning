package com.example.springlearnioc.springiocwithxml.helperclasses;

public class BaseBallCoach implements Coach {

    //define a private field for dependency
    private FortuneService fortuneService;

    //Constructor injection
     public BaseBallCoach(FortuneService fortuneService){
         this.fortuneService = fortuneService;
     }

    @Override
    public String getWorkoutdetails() {
        return "Do batting practice for 1 hr & "+ fortuneService.getFortune();
    }

    @Override
    public String giveFortune() {
        return fortuneService.getFortune();
    }
}

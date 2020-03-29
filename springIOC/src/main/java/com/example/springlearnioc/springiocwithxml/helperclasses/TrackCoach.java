package com.example.springlearnioc.springiocwithxml.helperclasses;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getWorkoutdetails() {
        return "Run for 2k";
    }

    @Override
    public String giveFortune() {
        return fortuneService.getFortune();
    }

    //method can have public, private, protected accessors only && no-argument
    public void executeBeforeBeanIsReady(){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Bean is getting ready !! I am before BeanReady");
        System.out.println("------------------------------------------------------------------------------");
    }

    public void executeAfterBeanDestroy(){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Bean is destroyed a little bit earlier before executing this method !! " +
                ", I am afterBeanDestroy !!");
        System.out.println("------------------------------------------------------------------------------");
    }
}

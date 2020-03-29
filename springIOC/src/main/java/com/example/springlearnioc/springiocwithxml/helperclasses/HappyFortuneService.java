package com.example.springlearnioc.springiocwithxml.helperclasses;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Wish you a happy fortune !";
    }
}

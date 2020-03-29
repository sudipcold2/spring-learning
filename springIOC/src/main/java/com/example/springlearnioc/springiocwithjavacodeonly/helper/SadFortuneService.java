package com.example.springlearnioc.springiocwithjavacodeonly.helper;

public class SadFortuneService implements FortuneService {
    @Override
    public String giveFortune() {
        return "Today is a sad day !!!";
    }
}

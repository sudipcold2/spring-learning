package com.example.springlearnioc.springiocwithjavaconfig.helper;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
    @Override
    public String giveFortune() {
        return "Always be happy !!";
    }
}

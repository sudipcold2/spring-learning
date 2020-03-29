package com.example.springlearnioc.springiocwithjavaconfig.helper;

import org.springframework.stereotype.Component;

@Component
public class DbFortune implements FortuneService {
    @Override
    public String giveFortune() {
        return "you are lucky to have a oracle db !!!";
    }
}

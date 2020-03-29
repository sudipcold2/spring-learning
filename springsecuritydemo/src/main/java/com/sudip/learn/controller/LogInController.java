package com.sudip.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {

    @GetMapping("/showMyLogInPage")
    public String showMyLogInPage(){
        return "log-in";
    }
}

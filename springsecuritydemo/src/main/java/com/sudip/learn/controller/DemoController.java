package com.sudip.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showLandingPaage(){
        return "landing";
    }

    @GetMapping("/employees")
    public String showDashBoardAfterLogIn(){
        return "home";
    }

    @GetMapping("/leaders")
    public String showLeadersPage(){
        return "leaders";
    }

    @GetMapping("/admin")
    public String showAdminPage(){
        return "admin";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }

}

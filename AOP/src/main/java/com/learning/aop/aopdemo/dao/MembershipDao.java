package com.learning.aop.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

    public void addSillyAccount(){
        System.out.println(getClass() + " Doing db stuff !!! adding member");
    }
}

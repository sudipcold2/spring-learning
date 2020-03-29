package com.learning.aop.aopdemo.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDao {

    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void addAccount(Account account){
        System.out.println(getClass() + " Doing some DB Work.");
    }

    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass() + " Doing some DB Work.");
    }

    public void doWork(){
        System.out.println(getClass() + " Do some hijibiji work");
    }

    public List<Account> findAccounts(){
        List<Account> myAccounts = new ArrayList<>();

        Account temp1 = new Account(201,"Binayak");
        Account temp2 = new Account(301, "Kumar");
        Account temp3 = new Account(401,"Sreemoyee");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

    public List<Account> findAccountsException(boolean exception){

        if(exception){
            throw new RuntimeException("Exception created from FindAccountsException() method");
        }

        List<Account> myAccounts = new ArrayList<>();

        Account temp1 = new Account(201,"Binayak");

        myAccounts.add(temp1);

        return myAccounts;
    }

}

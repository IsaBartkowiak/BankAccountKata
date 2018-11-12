package com.bankaccount.kata.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    private Integer id;
    private String name;
    private double balance;
    private History history;
    private static AtomicInteger at = new AtomicInteger(0);

    public Account(String name, double balance) {
        this.id =  at.incrementAndGet();
        this.name = name;
        this.balance = balance;
        this.history = new History();
    }

    public History getHistory() {
        return this.history;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }
}

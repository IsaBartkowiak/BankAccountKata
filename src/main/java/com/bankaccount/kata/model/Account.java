package com.bankaccount.kata.model;

import java.util.List;

public class Account {
    private long id;
    private String name;
    private double balance;
    private History history;

    public Account(long id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.history = new History();
    }

    public History getHistory() {
        return this.history;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

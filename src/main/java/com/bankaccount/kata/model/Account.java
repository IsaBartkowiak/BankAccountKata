package com.bankaccount.kata.model;

import java.util.List;

public class Account {
    private final long id;
    private final String name;
    public double balance;
    public final History history;

    public Account(long id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.history = new History();
        this.history.addLine(0, balance);
    }

    public List<Statement> getHistory() {
        return this.history.getStatements();
    }

    public long getId() {
        return id;
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

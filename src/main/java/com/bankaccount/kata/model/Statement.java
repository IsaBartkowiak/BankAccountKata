package com.bankaccount.kata.model;
import java.time.LocalDateTime;

public class Statement {

    private LocalDateTime localDate;
    private double amount;
    private double balance;
    private String operationType;

    Statement(LocalDateTime date, double amount, double balance) {
        this.localDate = date;
        this.amount = amount;
        this.balance = balance;
        this.operationType = amount > 0 ? "DEPOSIT" : "WITHDRAWAL";
    }

    @Override
    public String toString() {
        return this.operationType + " | " + this.localDate + " | " + this.amount + " | " + this.balance;
    }

    public LocalDateTime getLocalDate() {
        return this.localDate;
    }

    public double getAmount() {
        return this.amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getOperationType() {
        return this.operationType;
    }

}

package com.bankaccount.kata.model;
import java.time.LocalDateTime;

public class Statement {

    private LocalDateTime localDate;
    private double amount;
    private double balance;
    private String operationType;

    Statement(LocalDateTime date, double amount, double balance) throws Exception {
        this.localDate = date;
        this.amount = amount;
        this.balance = balance;
        if(amount == 0){
            throw new Exception("Amount of operation can't be 0");
        }
        this.operationType = amount > 0 ? "DEPOSIT" : "WITHDRAWAL";
    }

    @Override
    public String toString() {
        return this.operationType + " | " + this.localDate + " | " + this.amount + " | " + this.balance;
    }

    //for test
    public String getOperationType() {
        return this.operationType;
    }
}
package com.bankaccount.kata;

public class IllegalDepositException extends Throwable {

    public IllegalDepositException(String message) {
        super(message);
    }
}

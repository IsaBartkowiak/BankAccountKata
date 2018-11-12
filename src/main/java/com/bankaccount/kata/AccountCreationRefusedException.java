package com.bankaccount.kata;

public class AccountCreationRefusedException extends Throwable {

    public AccountCreationRefusedException(String  message) {
        super(message);
    }
}

package com.bankaccount.kata.exceptions;

public class AccountCreationRefusedException extends Throwable {

    public AccountCreationRefusedException(String  message) {
        super(message);
    }
}

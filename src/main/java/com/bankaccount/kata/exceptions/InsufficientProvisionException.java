package com.bankaccount.kata.exceptions;

public class InsufficientProvisionException extends Throwable {
    public InsufficientProvisionException(String message) {
        super(message);
    }
}

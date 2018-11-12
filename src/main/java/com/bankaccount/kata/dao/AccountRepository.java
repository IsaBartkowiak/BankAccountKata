package com.bankaccount.kata.dao;

import com.bankaccount.kata.model.Account;
import com.bankaccount.kata.model.Statement;

import java.util.List;

public interface AccountRepository {

    public Account createAccount(long id, String name, double balance);
    public Account depositOnAccount(long accountId, double amount);
    public Account withdrawalOnAccount(long accountId, double amount);
    public List<Statement> getHistory(long accountId);

}

package com.bankaccount.kata.dao;

import com.bankaccount.kata.model.Account;
import com.bankaccount.kata.model.Statement;

import java.util.List;

public interface AccountRepository {

    public Account createAccount(long id, String name, double balance) throws Exception;
    public Account depositOnAccount(long accountId, double amount) throws Exception;
    public Account withdrawalOnAccount(long accountId, double amount) throws Exception;
    public List<Statement> getHistory(long accountId);

}

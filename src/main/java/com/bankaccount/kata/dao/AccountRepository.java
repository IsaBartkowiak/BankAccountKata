package com.bankaccount.kata.dao;

import com.bankaccount.kata.model.Account;
import com.bankaccount.kata.model.Statement;

import java.util.List;

public interface AccountRepository {

    Account save(long id, String name, double balance) throws Exception;
    Account depositOnAccount(long accountId, double amount) throws Exception;
    Account withdrawalOnAccount(long accountId, double amount) throws Exception;
    List<Statement> getHistory(long accountId);

}

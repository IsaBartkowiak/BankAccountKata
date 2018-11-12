package com.bankaccount.kata.dao;

import com.bankaccount.kata.model.Account;
import com.bankaccount.kata.model.Statement;

import java.util.List;

public interface AccountRepository {

    Account save(Account account);
    Account findById(long id);
    List<Account> findAll();

}

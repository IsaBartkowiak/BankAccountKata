package com.bankaccount.kata.dao;

import com.bankaccount.kata.model.Account;

import java.util.List;

public interface AccountRepository {

    Account save(Account account);
    Account findById(Integer id);
    List<Account> findAll();

}

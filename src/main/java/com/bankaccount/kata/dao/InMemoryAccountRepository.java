package com.bankaccount.kata.dao;

import com.bankaccount.kata.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryAccountRepository implements AccountRepository {

    private Map<Integer, Account> list = new HashMap<>();

    @Override
    public List<Account> findAll() {
        return new ArrayList<Account>(list.values());
    }

    @Override
    public Account save(Account account) {
        list.put(account.getId(), account);
        return account;
    }

    @Override
    public Account findById(Integer id) {
        return list.get(id);
    }

}

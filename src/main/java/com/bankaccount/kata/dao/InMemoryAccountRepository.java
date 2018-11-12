package com.bankaccount.kata.dao;

import com.bankaccount.kata.model.Account;
import com.bankaccount.kata.model.Statement;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryAccountRepository implements AccountRepository {

    private Map<Long, Account> allAccounts = new HashMap<Long, Account>();

    @Override
    public List<Account> findAll() {
        return new ArrayList<Account>(allAccounts.values());
    }

    @Override
    public Account save(Account account) {
        if (account.getId() == -1) {
            account.setId((long) (Math.random() * 1000000));
        }
        allAccounts.put(account.getId(), account);
        return account;
    }

    @Override
    public Account findById(long id) {
        return allAccounts.get(id);
    }

    @Override
    public List<Statement> getHistory(long accountId){
        Account account = allAccounts.get(accountId); //for test
        return account.getHistory().getStatements();
    }
}

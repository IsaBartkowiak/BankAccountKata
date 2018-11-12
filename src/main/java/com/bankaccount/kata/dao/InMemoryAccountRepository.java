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
public class InMemoryAccountRepository implements AccountRepository{

    private Map<Long, Account> allAccounts = new HashMap<Long, Account>();

    public List<Account> findAll() {
        return new ArrayList<Account>(allAccounts.values());
    }

    public Account save(Account account) {
        if (account.getId() == -1) {
            account.setId((long) (Math.random() * 1000000));
        }
        allAccounts.put(account.getId(), account);
        return account;
    }

    public Account depositOnAccount(long accountId, double amount) throws Exception{
        Account account = allAccounts.get(accountId);  //for test
        double balanceAfter = account.getBalance() + amount;
        account.setBalance(balanceAfter);
        account.getHistory().addLine(amount, balanceAfter);
        return account;
    }

    public Account withdrawalOnAccount(long accountId, double amount) throws Exception{
        Account account = allAccounts.get(accountId); //for test
        double balanceAfter = account.getBalance() - amount;
        account.setBalance(balanceAfter);
        account.getHistory().addLine(-amount, balanceAfter);
        return account;
    }

    public List<Statement> getHistory(long accountId){
        Account account = allAccounts.get(accountId); //for test
        return account.getHistory().getStatements();
    }
}

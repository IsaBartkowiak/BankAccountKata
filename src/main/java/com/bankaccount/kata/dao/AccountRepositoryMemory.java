package com.bankaccount.kata.dao;

import com.bankaccount.kata.model.Account;
import com.bankaccount.kata.model.Statement;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class AccountRepositoryMemory implements AccountRepository{

    private static final HashMap<Long, Account> allAccounts = new HashMap<Long, Account>();

    @PostConstruct
    public void init() throws Exception {
        createAccount(1,"Isa account", 1000);
    }

    public List<Account> getAccounts() {
        return new ArrayList<Account>(allAccounts.values());
    }

    public Account createAccount(long id, String name, double balance) throws Exception{
        Account account = new Account(id, name, balance);
        allAccounts.put(id, account);
        return account;
    }

    public Account depositOnAccount(long accountId, double amount) throws Exception{
        Account account = allAccounts.get(accountId);  //for test
        double balanceAfter = account.getBalance() + amount;
        account.setBalance(balanceAfter);
        account.history.addLine(amount, balanceAfter);
        return account;
    }

    public Account withdrawalOnAccount(long accountId, double amount) throws Exception{
        Account account = allAccounts.get(accountId); //for test
        double balanceAfter = account.getBalance() - amount;
        account.setBalance(balanceAfter);
        account.history.addLine(-amount, balanceAfter);
        return account;
    }

    public List<Statement> getHistory(long accountId){
        Account account = allAccounts.get(accountId); //for test
        return account.getHistory();
    }
}

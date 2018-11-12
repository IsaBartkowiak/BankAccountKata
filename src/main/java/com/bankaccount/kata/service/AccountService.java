package com.bankaccount.kata.service;

import com.bankaccount.kata.dao.AccountRepository;
import com.bankaccount.kata.dao.InMemoryAccountRepository;
import com.bankaccount.kata.model.Account;
import com.bankaccount.kata.model.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccounts() {
        return this.accountRepository.findAll();
    }

    public Account createNewAccount(Account account) throws Exception{
        account = this.accountRepository.save(account);
        return account;
    }

    public Account depositOnAccount(long accountId, double amount) throws Exception{
        return this.accountRepository.depositOnAccount(accountId, amount);
    }

    public Account withdrawalOnAccount(long accountId, double amount) throws Exception{
        return this.accountRepository.withdrawalOnAccount(accountId, amount);
    }

    public List<Statement> history(long accountId){
        return this.accountRepository.getHistory(accountId);
    }
}

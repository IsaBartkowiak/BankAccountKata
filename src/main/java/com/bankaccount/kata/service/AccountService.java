package com.bankaccount.kata.service;

import com.bankaccount.kata.exceptions.AccountCreationRefusedException;
import com.bankaccount.kata.exceptions.IllegalDepositException;
import com.bankaccount.kata.dao.AccountRepository;
import com.bankaccount.kata.model.Account;
import com.bankaccount.kata.model.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {

    public static final int MINIMUM_AMOUNT_FOR_ACCOUNT_CREATION = 1000;
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccounts() {
        return this.accountRepository.findAll();
    }

    public Account createNewAccount(Account account) throws AccountCreationRefusedException {
        if (account.getId() != -1) {
            throw new AccountCreationRefusedException("Account may already exist");
        }
        if (account.getBalance() < MINIMUM_AMOUNT_FOR_ACCOUNT_CREATION) {
            throw new AccountCreationRefusedException("Initial balance should be at least 1000");
        }
        account = this.accountRepository.save(account);
        return account;
    }

    public Account depositOnAccount(long accountId, double amount) throws IllegalDepositException {
        if (amount <= 0) {
            throw new IllegalDepositException("Deposit amount must be positive");
        }
        Account account = this.accountRepository.findById(accountId);
        double balanceAfter = account.getBalance() + amount;
        account.setBalance(balanceAfter);
        account.getHistory().addStatement(amount, balanceAfter);
        return account;
    }

    public Account withdrawalOnAccount(long accountId, double amount) {
        Account account = this.accountRepository.findById(accountId);
        double balanceAfter = account.getBalance() - amount;
        account.setBalance(balanceAfter);
        account.getHistory().addStatement(-amount, balanceAfter);
        return account;
    }

    public List<Statement> history(long accountId){
        return this.accountRepository.getHistory(accountId);
    }
}

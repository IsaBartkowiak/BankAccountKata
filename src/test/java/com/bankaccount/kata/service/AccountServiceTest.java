package com.bankaccount.kata.service;


import com.bankaccount.kata.exceptions.AccountCreationRefusedException;
import com.bankaccount.kata.exceptions.IllegalDepositException;
import com.bankaccount.kata.model.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.InsufficientResourcesException;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void should_account_creation_be_authorized_when_initial_amount_is_above_1000_euros() throws AccountCreationRefusedException {
        Account accountToCreate = new Account(-1, "My account", 1000);

        Account createdAccount = accountService.createNewAccount(accountToCreate);

        assertThat(createdAccount).isNotNull();
    }

    @Test(expected = AccountCreationRefusedException.class)
    public void should_account_creation_be_refused_when_initial_amount_is_below_1000_euros() throws AccountCreationRefusedException {
        Account accountToCreate = new Account(-1, "My account", 900);

        accountService.createNewAccount(accountToCreate);
    }

    @Test(expected = AccountCreationRefusedException.class)
    public void should_account_creation_be_refused_when_account_id_is_invalid() throws AccountCreationRefusedException {
        Account accountToCreate = new Account(2, "My account", 1000);

        accountService.createNewAccount(accountToCreate);
    }

    @Test
    public void should_accept_deposit_when_amount_is_positive() throws AccountCreationRefusedException, IllegalDepositException {
        Account account = new Account(-1, "My account", 1000);
        account = this.accountService.createNewAccount(account);

        Account updatedAccount = accountService.depositOnAccount(account.getId(), 1000);

        assertThat(updatedAccount.getBalance()).isEqualTo(2000);
    }

    @Test(expected = IllegalDepositException.class)
    public void should_refuse_deposit_when_amount_is_negative() throws AccountCreationRefusedException, IllegalDepositException {
        Account account = new Account(-1, "My account", 1000);
        account = this.accountService.createNewAccount(account);

        accountService.depositOnAccount(account.getId(), -50);
    }

    @Test
    public void should_withdrawal_be_allowed_when_account_has_enough_provision() throws AccountCreationRefusedException {
        Account account = new Account(1, "My account", 1000);
        account = this.accountService.createNewAccount(account);

        Account updatedAccount = accountService.withdrawalOnAccount(account.getId(), 1000);
        assertThat(updatedAccount.getBalance()).isEqualTo(0);
    }

    @Test(expected = InsufficientProvisionException.class)
    public void should_withdrawal_be_refused_when_account_has_not_enough_provision() throws AccountCreationRefusedException {
        Account account = new Account(1, "My account", 1000);
        account = this.accountService.createNewAccount(account);

        Account updatedAccount = accountService.withdrawalOnAccount(account.getId(), 1001);
    }
}
